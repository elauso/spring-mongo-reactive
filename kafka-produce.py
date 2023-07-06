from json import dumps
from kafka import KafkaProducer
from kafka.errors import KafkaError

# python3 -m venv .venv
# source .venv/bin/activate
# pip install kafka-python

producer = KafkaProducer(
    bootstrap_servers=['localhost:9092'],
    value_serializer=lambda x: dumps(x).encode('utf-8'))

data = {'id':1,'name':'test','type':'CONVENIENCE','code':'7add0466-1bb9-11ee-be56-0242ac120002'}
future = producer.send('queueing.example.product.created', value=data)

try:
    record_metadata = future.get(timeout=10)
except KafkaError:
    log.exception()
    pass