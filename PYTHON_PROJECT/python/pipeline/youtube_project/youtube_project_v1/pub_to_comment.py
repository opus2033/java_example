#-*- coding:utf-8 -*-

from google.cloud import pubsub_v1
import os
import requests
import time
import json
import sys
import collections

os.environ["GOOGLE_APPLICATION_CREDENTIALS"] = "C:\gcloud_key//freud-int-200423-owner-88790c68f84a.json"

project_id = "freud-int-200423"
topic_id = "youtube_comment_v3"
channel_id = 'pC6tPEaAiYU'


page = 50
API_KEY = 'AIzaSyDjqV0pqj2DUoRwSoPQQdPhE4E_JPYCp8w'

publisher = pubsub_v1.PublisherClient()
topic = 'projects/{}/topics/{}'.format(project_id, topic_id)

url = "https://www.googleapis.com/youtube/v3/commentThreads?key={}&textFormat=plainText&part=snippet&videoId={}&maxResults={}".format(API_KEY,channel_id,page)

response = requests.get(url).text
dic = json.loads(response)

for i in range(page-49,page):
  for item in dic['items']:
    item2 = item['snippet']['topLevelComment']['snippet']['textOriginal']
    data = bytes(item2, 'utf-8')
    message_future = publisher.publish(
        topic,
        data=data,
    )
    time.sleep(1)
    print(data)
    page += 50