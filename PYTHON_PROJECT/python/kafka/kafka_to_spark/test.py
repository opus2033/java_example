from kafka import KafkaConsumer

consumer = KafkaConsumer('test-v13',bootstrap_servers=['34.70.151.26:9092'])
for message in consumer:
    print(message.value)
    # print ("%s:%d:%d: key=%s value=%s" % (message.topic, message.partition,
    #             message.offset, message.key,
    #             message.value))