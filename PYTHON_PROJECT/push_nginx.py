import requests
import time

for i in range(1,100000):
    url = requests.get('http://104.197.13.243/')
    time.sleep(5)
    print(i)
    # url2 = requests.get('http://34.66.169.255/')
    # time.sleep(0.3)
    # url3 = requests.get('http://34.66.169.255/')
    # time.sleep(0.5)
    # url4 = requests.get('http://34.66.169.255/')
    # time.sleep(1)
    # url5 = requests.get('http://34.66.169.255/')
    # time.sleep(3)
    # url6 = requests.get('http://34.66.169.255/')
    # time.sleep(1.3)
