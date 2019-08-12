# Spring Boot with Kafka Producer Example
This Project covers how to use Spring Boot with Spring Kafka to Publish JSON/String message to a Kafka topic

## Start Zookeeper
- `C:\kafka_2.12-2.2.1>.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties`

## Start Kafka Server
- `C:\kafka_2.12-2.2.1>.\bin\windows\kafka-server-start.bat .\config\server.properties`

## Create Kafka Topic
- `C:\kafka_2.12-2.2.1>.\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic Kafka_Example`

## Consume from the Kafka Topic via Console
- `C:\kafka_2.12-2.2.1>.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic Kafka_Example --from-beginning`

## Publish message via WebService
- http://localhost:8080/kafka/publish/Sam
- http://localhost:8080/kafka/publish/Peter