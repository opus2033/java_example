import com.google.cloud.spark.bigquery._
import org.apache.spark.sql._
import org.apache.spark.sql.types._
import org.apache.spark._
import kafka.serializer.StringDecoder
import kafka.producer.Producer
import kafka.producer.KeyedMessage
import kafka.producer.ProducerConfig
import org.apache.spark.streaming._
import org.apache.spark.streaming.kafka._


val appName = "Scala Example - List to Spark Data Frame"
val master = "local"

val ssc = new StreamingContext(sc, Seconds(5))

val spark = SparkSession.builder.appName(appName).master(master).getOrCreate()

val kafkaReceiverParams = Map[String, String](
    "metadata.broker.list" -> "34.123.104.28:9092")


val kafkaStream = KafkaUtils.createDirectStream[String, String, StringDecoder, StringDecoder](
    ssc, 
    kafkaReceiverParams, 
    Set("spark"))



val schema = StructType(List(
  StructField("Category", StringType, true)
))

val rdd = spark.sparkContext.parallelize(kafkaStream)
val df = spark.createDataFrame(rdd, schema)
print(df.schema)
df.show()

ssc.start()
ssc.awaitTermination(5)