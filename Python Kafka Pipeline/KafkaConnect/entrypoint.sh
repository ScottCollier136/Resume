#!/bin/sh

kafka_ready() {
python << END
import kafka
import sys

try:
  consumer = kafka.KafkaConsumer(bootstrap_servers=['kafka:9092'])
  topics = consumer.topics()

  if not topics: 
      sys.exit(-1)
except:
  sys.exit(-1)

sys.exit(0)

END
}

echo "Starting..."

/bin/connect-standalone /worker.properties /connector.properties.d/*