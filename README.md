### start kafka
```
bin/zookeeper-server-start.sh config/zookeeper.properties
bin/kafka-server-start.sh config/server.properties
```

### Start and Stop redis server
```
$ redis-server
Ctrl-C
```

### database
```
mongo
brew services start mongodb-community
neo4j
bin/neo4j start 
```
