import pyspark

# Subscribe to 1 topic
df = spark \
  .readStream \
  .format("kafka") \
  .option("kafka.bootstrap.servers", "34.70.151.26:9092") \
  .option("subscribe", "test-v13") \
  .load()
df.selectExpr("CAST(key AS STRING)", "CAST(value AS STRING)")