import requests
from random import *
import datetime as pydatetime
import time

def get_now():
    return pydatetime.datetime.now()

def get_now_timestamp():
    return int(get_now().timestamp())

for i in range(1,5000):
    form = { 
        "metric": "test-v8",
        "timestamp": get_now_timestamp(),
        "value": randint(1,100),
        "tags": 
        { 
            "type": "test-v7"
        }
    }



    

    time.sleep(1)
    data = requests.post('http://35.193.143.156:4242/api/put?details', json=form)
    print(data.text)
    print(data)

