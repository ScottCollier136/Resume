from kafka import KafkaProducer
import time
from datetime import datetime
import random

i = 0;
producer = KafkaProducer(bootstrap_servers="kafka:9092")

for i in range(3):

    current_timestamp = datetime.now().timestamp()
    dataToSend = (
        """{
        "Time": """ + str(current_timestamp)+ """,
        "Value1": """ + str(random.randrange(20,30))+ """,
        "Value2": """ + str(random.randrange(5,10))+ """,
        }"""
    )

    producer.send('test-topic', bytes(dataToSend, "utf-8"))
    print("message sent")    
    time.sleep(5)

