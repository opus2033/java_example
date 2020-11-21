import argparse
import random
import time
import os

from flask import Flask, redirect, url_for

from opencensus.ext.stackdriver import trace_exporter as stackdriver_exporter
import opencensus.trace.tracer

os.environ["GOOGLE_APPLICATION_CREDENTIALS"] = "C:\gcloud_key/freud-int-200423-owner-88790c68f84a.json"

def initialize_tracer(project_id):
    exporter = stackdriver_exporter.StackdriverExporter(
        project_id=project_id
    )
    tracer = opencensus.trace.tracer.Tracer(
        exporter=exporter,
        sampler=opencensus.trace.tracer.samplers.AlwaysOnSampler()
    )

    return tracer


app = Flask(__name__)


@app.route('/', methods=['GET'])
def root():
    return redirect(url_for('test'))




@app.route('/test.html', methods=['GET'])
def test():
    tracer = app.config['TRACER']
    tracer.start_span(name='test')

    time.sleep(random.random() ** 2)
    result = "test page"

    tracer.end_span()
    return result



if __name__ == '__main__':
    parser = argparse.ArgumentParser(
        description=__doc__,
        formatter_class=argparse.RawDescriptionHelpFormatter
    )
    parser.add_argument(
        '--project_id', help='Project ID you want to access.', required=True)
    args = parser.parse_args()

    tracer = initialize_tracer(args.project_id)
    app.config['TRACER'] = tracer

    app.run()