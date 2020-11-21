from bs4 import BeautifulSoup
import time
from selenium import webdriver
from selenium.webdriver import Chrome
from selenium.webdriver.common.keys import Keys
from google.cloud import pubsub_v1
import os
import requests
import time
import json
import sys
import re
import multiprocessing

os.environ["GOOGLE_APPLICATION_CREDENTIALS"] = "C:\gcloud_key//freud-int-200423-owner-88790c68f84a.json"

# options = webdriver.ChromeOptions()
# options.add_argument('headless')
# options.add_argument('window-size=1920x1080')
# options.add_argument("disable-gpu")


project_id = "freud-int-200423"
topic_id = "youtube_comment_v1"
channel = 'pC6tPEaAiYU'
url = 'https://www.youtube.com/watch?v='+ channel+'&list=RDpC6tPEaAiYU&start_radio=1'
publisher = pubsub_v1.PublisherClient()
topic = 'projects/{}/topics/{}'.format(project_id, topic_id)
num_scroll = int(input('스크롤 횟수 지정 : '))


browser = Chrome()
browser.get(url)
browser.maximize_window()
browser.implicitly_wait(5)


body = browser.find_element_by_tag_name('body')

print("scroll down ready.....")
print("scroll down real start.....")

while num_scroll:
    body.send_keys(Keys.PAGE_DOWN)
    time.sleep(0.11)
    num_scroll -= 1

html = browser.page_source
browser.quit()
bsObj = BeautifulSoup(html, 'lxml')
comment = bsObj.findAll('yt-formatted-string', attrs={'class': 'style-scope ytd-comment-renderer'})


print("list insert.......")
print("pubsub start.......")

for i in range(len(comment)):
    test = comment[i].text
    data = bytes(str(test), 'utf-8')
    message_future = publisher.publish(
        topic,
        data=data,
        time.sleep(0.1)
        )

browser.quit()

