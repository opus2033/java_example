from bs4 import BeautifulSoup
import time
from selenium import webdriver
from selenium.webdriver import Chrome
from selenium.webdriver.common.keys import Keys
import os
import requests
import time
import json
import sys
import re


url = 'http://127.0.0.1:3000/board1/list'
num = int(input('게시판 글 등록 갯수 : '))

browser = Chrome()
browser.get(url)
browser.maximize_window()
browser.implicitly_wait(30)


def enroll(num):
    body = browser.find_element_by_tag_name('body')

    for i in range(1,num):

