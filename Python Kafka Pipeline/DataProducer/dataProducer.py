from kafka import KafkaProducer
import time
from datetime import datetime
import random
import json

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

    dataToSend = (
        """{"value1": 6,"value2": 5}"""
    )

    data = {
        "value1": 10,
        "value2": 20
    }
    myJSON = json.dumps(data)

    #producer.send('postgrestable', bytes(dataToSend, "utf-8"))
    producer.send('catdog2', bytes(myJSON, "utf-8"))
    print("message sent")    
    time.sleep(5)

