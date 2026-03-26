#!/bin/sh

kafka_ready() {
python << END
import kafka
import sys

try:
  consumer = kafka.KafkaConsumer(group_id='test', bootstrap_servers=['kafka:9092'])
  topics = consumer.topics()

  if not topics: 
      sys.exit(-1)
except:
  sys.exit(-1)

sys.exit(0)

END
}



echo "Checking for Kafka ..."



# Once the schema-registry is set up, define the schemas needed for the spark-return values to work with the postgres sink
# The other data's schemas will be auto generated through the process of the other connectors
#curl -X POST -H "Content-Type: application/vnd.schemaregistry.v1+json" --data '{"schemaType":"JSON","schema": "{\"type\":\"object\",\"title\":\"com.datamountaineer.streamreactor.common.converters.MsgKey\",\"properties\":{\"topic\":{\"type\":\"string\",\"connect.index\":0},\"id\":{\"type\":\"string\",\"connect.index\":1}}}"}' http://schema-registry:8081/subjects/analysed_1-key/versions
#curl -X POST -H "Content-Type: application/vnd.schemaregistry.v1+json" --data '{"schemaType":"JSON","schema": "{\"type\":\"object\",\"title\":\"analysedSchema\",\"properties\":{\"time_stamp\":{\"connect.index\":1,\"oneOf\":[{\"type\":\"null\"},{\"type\":\"string\"}]},\"label\":{\"connect.index\":0,\"oneOf\":[{\"type\":\"null\"},{\"type\":\"string\"}]},\"equipment_num\":{\"connect.index\":3,\"oneOf\":[{\"type\":\"null\"},{\"type\":\"string\"}]},\"project\":{\"connect.index\":4,\"oneOf\":[{\"type\":\"null\"},{\"type\":\"string\"}]}}}"}' http://schema-registry:8081/subjects/analysed_1-value/versions



echo "Starting Producer ..."

python /dataProducer.py
