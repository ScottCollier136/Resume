import sys
import time
from kafka import KafkaConsumer

kafka_consumer = KafkaConsumer('test-topic', bootstrap_servers="kafka:9092")

#wait 10 seconds. theres a bug where the consumer wont read right until producer starts first?
time.sleep(10)

while True:
    for data in kafka_consumer:
        print(data, file=sys.stderr)