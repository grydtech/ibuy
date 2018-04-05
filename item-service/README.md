## Item Service
### How to compile
run `mvn clean package` and it will create an executable jar file inside target directory
### How to run
#### Start zookeeper and kafka
1. Download [apache kafka](https://kafka.apache.org/downloads)
2. Start a ZooKeeper server. Kafka has a single node Zookeeper configuration built-in.
```bash
bin/zookeeper-server-start.sh config/zookeeper.properties
```
3. Start kafka
```bash
bin/kafka-server-start.sh config/server.properties
```
4. Create required topics (order-created, item-added, order-finalized)
```bash
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic item-created-event
```
#### Start order service
```bash
java -jar order-service-1.0.jar
```
it will start jetty embedded servlet container and start jax rs application  
### Test event consumer
To test and view events emitted by order service use [apache-kafka-sample](https://github.com/randilfernando/apache-kafka-sample)