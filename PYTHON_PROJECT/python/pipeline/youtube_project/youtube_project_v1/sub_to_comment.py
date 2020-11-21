from concurrent.futures import TimeoutError
from google.cloud import pubsub_v1
import os
import time
import json
import base64


project_id = "freud-int-200423"
subscription_id = "youtube_comment_v3"
timeout = 20

os.environ["GOOGLE_APPLICATION_CREDENTIALS"] = "C:\gcloud_key//freud-int-200423-owner-88790c68f84a.json"

subscriber = pubsub_v1.SubscriberClient()
subscription_path = subscriber.subscription_path(project_id, subscription_id)

def callback(message):
    test = message.data
    test1 = test.decode(encoding = 'utf-8')
    # test1 = test.decode('utf-8')
    # test = base64.b64decode(message['data']).decode('utf-8')
    # record = json.loads(test)


    # test = message.data
    # test1 = test.decode(encoding = 'UTF-8')
    print(test1)

    time.sleep(15)
    message.ack()

streaming_pull_future = subscriber.subscribe(subscription_path, callback=callback)
time.sleep(15)
print("Listening for messages on {}..\n".format(subscription_path))

with subscriber:
    try:
        streaming_pull_future.result(timeout=timeout)    
    except TimeoutError:
        streaming_pull_future.cancel()