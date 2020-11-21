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

channel = 'pC6tPEaAiYU'
url = 'https://www.youtube.com/watch?v='+ channel+'&list=RDpC6tPEaAiYU&start_radio=1'
test = []
num_scroll = int(input('스크롤 횟수 지정 : '))

browser = Chrome()
browser.get(url)
browser.maximize_window()
browser.implicitly_wait(30)

body = browser.find_element_by_tag_name('body')

while num_scroll:

    body.send_keys(Keys.PAGE_DOWN)
    time.sleep(0.18)
    num_scroll -= 1

html = browser.page_source
browser.quit()
bsObj = BeautifulSoup(html, 'lxml')
comment = bsObj.findAll('yt-formatted-string', attrs={'class': 'style-scope ytd-comment-renderer'})

# comment_list.append(comment)
# print(comment_list[-1])



for i in range(len(comment)):
    test = comment[i].text
    print(test)
