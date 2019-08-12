# Spring Boot with Kafka Consumer Example

This Project covers how to use Spring Boot with Spring Kafka to Consume JSON/String message from Kafka topics

## Start Zookeeper
- `C:\kafka_2.12-2.2.1>.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties`

## Start Kafka Server
- `C:\kafka_2.12-2.2.1>.\bin\windows\kafka-server-start.bat .\config\server.properties`

## Create Kafka Topic
- `C:\kafka_2.12-2.2.1>.\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic Kafka_Example`
- `C:\kafka_2.12-2.2.1>.\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic Kafka_Example_JSON`

## Publish to the Kafka Topic via Console
- `C:\kafka_2.12-2.2.1>.\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic Kafka_Example Danny`
- `C:\kafka_2.12-2.2.1>.\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic Kafka_Example_JSON Totha`