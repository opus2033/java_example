import os
import re
import logging
import json
import argparse
import apache_beam as beam


os.environ["GOOGLE_APPLICATION_CREDENTIALS"] = "C:\gcloud_key/freud-int-200423-owner-88790c68f84a.json"


# def parse_pubsub(message):
#   data = message.decode('utf-8')
#   record = json.loads(data)
#   return record
  
  # test = json.loads(line,encoding='utf-8')
  # test = json.loads(line.decode('utf-8'))
  # test1 = test.decode(encoding ='utf-8')

  # 두번째 수
  # test = json.loads(line)
  # test1 = test.decode(encoding ='utf-8')
  # test1 = base64.b64decode(test['data']).decode('utf-8')

  # test = line['data']
  # test1 = test.decode(encoding = 'utf-8')
  # test1 = base64.b64decode(test.decode('utf-8'))
  # test1 = base64.urlsafe_b64decode(test)
  # test2 = test1.decode(encoding = 'utf-8')
  # test1 = test.decode('utf-8')
  # record = json.loads(test)
  # test = json.loads(line)
  # test1 = test.decode('utf-8')
  # test2 =  str(test1)
  

def run(argv=None):
  parser = argparse.ArgumentParser()
  parser.add_argument(
      '--input_topic', required=True,
      help='Input PubSub topic of the form "/topics/<PROJECT>/<TOPIC>".')

  known_args, pipeline_args = parser.parse_known_args(argv)


  with beam.Pipeline(argv=pipeline_args) as p:
    data_from_source = ( p | 'input pubsub' >> beam.io.ReadFromPubSub(known_args.input_topic)
                          #  | 'Write' >> beam.Map(parse_pubsub)
                           | beam.Map(lambda comment : {'comment': comment})
                        )

    project_id = 'freud-int-200423'
    dataset_id = 'youtube'
    table_id = 'youtube'
    table_schema = ('comment:STRING')

    data_from_source | beam.io.WriteToBigQuery(
                    table=table_id,
                    dataset=dataset_id,
                    project=project_id,
                    schema=table_schema,
                    create_disposition=beam.io.BigQueryDisposition.CREATE_IF_NEEDED,
                    write_disposition=beam.io.BigQueryDisposition.WRITE_APPEND)

    result = p.run()
    result.wait_until_finish()
                
if __name__ == '__main__':
  logging.getLogger().setLevel(logging.INFO)
  run()