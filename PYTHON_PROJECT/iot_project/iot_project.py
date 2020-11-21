import requests
import time
import datetime as pydatetime
import json
from random import *
from google.cloud import pubsub_v1
import jwt
import base64



project_id = "freud-int-200423"
topic_id = "yun-test-v1"

publisher = pubsub_v1.PublisherClient()
topic = 'projects/{}/topics/{}'.format(project_id, topic_id)


def get_now():
    return pydatetime.datetime.now()

def get_now_timestamp():
    return int(get_now().timestamp())


for i in range(1,10000):
    form = { 
            "tags" : "iot_data",
            "data" : {
                "timestamp" : get_now_timestamp(),
                "x" : uniform(1,100),
                "y" : uniform(1,100),
                "temperature" : uniform(10,30)
                },
            }
    json_body = json.dumps(form)
    data = bytes(json_body, 'utf8')
    message_future = publisher.publish(
        topic, 
        data=data,
        ) 
    time.sleep(0.5)
    print(data)



   

