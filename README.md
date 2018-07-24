# kafkademo
KAFKA java 操作demo
一、首先安装kafka：
 kafka-server-start.sh 
USAGE: /data/server/kafka_2.11-0.9.0.0/bin/kafka-server-start.sh [-daemon] server.properties [--override property=value]*
创建topic
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic hellotopic
查看所有topic
 bin/kafka-topics.sh --list --zookeeper localhost:2181
 发送消息
 bin/kafka-console-producer.sh --broker-list localhost:9092 --topic hellotopoc
 
 消费消息  from-beginning从头开始消费，重复消费
 bin/kafka-console-consumer.sh --zookeeper localhost:2181 --topic hellotopoc --from-beginning
 
 查看所有topic的详细信息：kafka-topics.sh --describe --zookeeper localhost:2181
  查看指定topic的详细信息：
  
  
  一个节点多block
  后台启动运行kafka
  kafka-server-start.sh -daemon $KAFKA_HOME/config/server-1.properties &
 kafka-server-start.sh -daemon $KAFKA_HOME/config/server-2.properties & 
 kafka-server-start.sh -daemon $KAFKA_HOME/config/server-3.properties &  
 创建一个topic
kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 3 --partitions 1 --topic my-replicated-topic
生产者
kafka-console-producer.sh --broker-list localhost:9093,localhost:9094,localhost:9095 --topic my-replicated-topic
消费者
kafka-console-consumer.sh --zookeeper localhost:2181 --from-beginning --topic my-replicated-topic


具体参考kafka官网

二：使用java API操作kafka
