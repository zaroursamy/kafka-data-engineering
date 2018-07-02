# Homework tweets

The project provides two programs for handling tweets data:
- One uses Kafka Streams for filtering and modelize data from a topic to another one
- One uses a simple Kafka consumer in order to stream data from a topic to an in-memory database (Redis)

## Getting Started

Parameters for Kafka and Redis have to be specified in src/main/resources/application.conf.
Then you juste have to launch a main class with two parameters:
- --env : local or clusterprod (or another parameter specified in your application.conf)
- --from-beginning: true or false (if you want to read Kafka with a random group-id or not)
### Prerequisites

You need to install :
- Kafka server 1.X (1.0.0 is used here)
- Redis server (4.0.10 is used here)
- SBT (1.1.6 is used here)

Don't forget to add in your plugins.sbt:
```
addSbtPlugin("org.scalariform" % "sbt-scalariform" % "1.8.2")
addSbtPlugin("org.xerial.sbt" % "sbt-pack" % "0.11")
```

### Installing

Run your Zookeeper and Kafka server from your Kafka directory
```
./bin/zookeeper-server-start config/zookeeper.properties
./bin/kafka-server-start config/server.properties
```
By default, Kafka is running on localhost:9092 and Zookeeper on localhost:2181

Then run your Redis server:
```
redis-server /usr/local/etc/redis.conf
```
By default, Redis is running on localhost:6379


Then you can launch one of the main class with SBT.

Example:
```
sbt "runMain main.KafkaStreamsMario --env local --from-beginning true"
sbt "runMain main.FromKafkaToDb --env clusterprod --from-beginning false"
```

## Running the tests

For running unit tests, just launch the following SBT command:
```
sbt test
```

