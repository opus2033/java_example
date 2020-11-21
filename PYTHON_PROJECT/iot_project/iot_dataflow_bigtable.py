import datetime
import apache_beam as beam

from apache_beam.options.pipeline_options import PipelineOptions
from apache_beam.io.gcp.bigtableio import WriteToBigTable
from google.cloud.bigtable import row


class MyOptions(PipelineOptions):
    @classmethod
    def _add_argparse_args(cls, parser):
        parser.add_argument(
            '--bigtable-project',
            help='The Bigtable project ID, this can be different than your '
                 'Dataflow project',
            default='bigtable-project')
        parser.add_argument(
            '--bigtable-instance',
            help='The Bigtable instance ID',
            default='bigtable-instance')
        parser.add_argument(
            '--bigtable-table',
            help='The Bigtable table ID in the instance.',
            default='bigtable-table')


class CreateRowFn(beam.DoFn):
    def process(self, key):
        direct_row = row.DirectRow(row_key=key)
        direct_row.set_cell(
            "stats_summary",
            b"os_build",
            b"android",
            datetime.datetime.now())
        return [direct_row]


def run(argv=None):
    """Build and run the pipeline."""
    options = MyOptions(argv)
    with beam.Pipeline(options=options) as p:
        p | beam.Create(["phone#4c410523#20190501",
                         "phone#4c410523#20190502"]) | beam.ParDo(
            CreateRowFn()) | WriteToBigTable(
            project_id=options.bigtable_project,
            instance_id=options.bigtable_instance,
            table_id=options.bigtable_table)


if __name__ == '__main__':
    run()