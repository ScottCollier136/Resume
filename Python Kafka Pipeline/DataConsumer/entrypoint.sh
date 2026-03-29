#!/bin/sh

kafka_ready() {
python << END
import kafka
import sys

try:
  consumer = kafka.KafkaConsumer(group_id='test', bootstrap_servers=['kafka:9092'])
  topics = consumer.topics()

  if not topics: 
      print("")
      sys.exit(-1)
except:
  sys.exit(-1)

sys.exit(0)

END
}

echo "Checking for Kafka ..."

echo "Starting Consumer ..."

python /dataConsumer.py
