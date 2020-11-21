import json
import logging
import argparse
import datetime
import apache_beam as beam
from apache_beam.io.gcp.bigtableio import WriteToBigTable
import apache_beam.io.gcp.bigtableio
from google.cloud.bigtable import row
from apache_beam.options.pipeline_options import PipelineOptions

## 파이프라인 옵션지정 ##
pipeline_options = PipelineOptions(None)
DEST_DIR = "gs://freud-int-200423/"
options = {
    'project' : 'freud-int-200423',
    'region' : 'us-central1',
    'staging_location' : DEST_DIR + 'staging',
    'temp_location' : DEST_DIR + 'tmp',
    'job_name' : 'iot-test-exam-v99',
    'streaming': 'true',
    'enable_streaming_engine' : 'true' 
}
opts = beam.pipeline.PipelineOptions(flags=[], **options)


## bigtable row키 설정 ##
class CreateRowFn(beam.DoFn):
    def process(self, key):
        column_family_id = "cf1"
        direct_row = row.DirectRow(row_key=key)
        direct_row.set_cell(column_family_id,
                 "iot_temperature",
                 1,)
        return [direct_row]


## iot 데이터 나누기 ##

def bq_in(source):
    bq = {}
    bq['metric'] = source['metric']
    bq['x'] = source['data']['x']
    bq['y'] = source['data']['y']
    json.dumps(bq)
    return bq

def bt_in(source):
    bt = {}
    bt['metric'] = source['metric']
    bt['timestamp'] = source['data']['timestamp']
    bt['temperature'] = source['data']['temperature']
    bigtable_test = json.dumps(bt)
    big_table_input = bytes(bigtable_test,'utf8')
    return big_table_input
    


## 파이프라인 실행 ##
def run(argv=None):
    with beam.Pipeline(options=opts) as p:
        from apache_beam.io.gcp.internal.clients import bigquery 
        project_id = 'freud-int-200423'
        dataset_id = 'iot_table'
        table_id = 'iot_geo'
        table_schema = 'metric:string, x:float , y:float'

        # pubsub 읽기
        data_from_source =  ( p | 'input pubsub' >> beam.io.ReadFromPubSub('projects/freud-int-200423/topics/iot_exam_test')
        )

        # 디코드 후 빅쿼리 넣기
        input_bigquery = ( data_from_source  | 'transform data' >> beam.Map(lambda data_from_source : json.loads(data_from_source))
        )
        # 빅쿼리 값 추출하기
        extract_bigquery = ( input_bigquery | 'extract bigquery' >> beam.Map(bq_in)
        )

        write_bigquery = ( extract_bigquery | 'write bigquery' >>  beam.io.WriteToBigQuery(
                                                    project=project_id,
                                                    dataset=dataset_id,
                                                    table=table_id,
                                                    schema=table_schema,
                                                    create_disposition=beam.io.BigQueryDisposition.CREATE_IF_NEEDED,
                                                    write_disposition=beam.io.BigQueryDisposition.WRITE_APPEND)
        )
        # 빅테이블 값 추출하기
        extract_bigtable = ( input_bigquery | 'extract bigtable' >> beam.Map(bt_in)
        )

        # 디코드하지않고 빅테이블넣기 , value값을 지정해줘야함.
        input_bigtable = ( extract_bigtable  |  'transform bigtable' >> beam.ParDo(CreateRowFn('iot'))
                                             |  'Write Bigtable' >> WriteToBigTable(
                                                    project_id='freud-int-200423',
                                                    instance_id='yun-sandbox',
                                                    table_id= 'iot-temperature'
                    )
        )

    result = p.run()
    result.wait_until_finish()

if __name__ == '__main__':
    logging.getLogger().setLevel(logging.INFO)
    run()