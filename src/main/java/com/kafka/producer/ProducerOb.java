package com.kafka.producer;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import java.util.Properties;

public class ProducerOb {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("acks", "all");
        props.put("retries", 1);
        Producer<String, String> producer = new KafkaProducer<String, String>(props);
        int i = 0;
        while (true){
            try {
                producer.send(new ProducerRecord<String, String>("hellotopic", "第"+i+"次消息Hello你好"));
                Thread.sleep(2000L);
                i++;
                System.out.println("发消息"+i+"ci");
            }catch (Exception e){
                e.printStackTrace();
            }
//            producer.send(new ProducerRecord<String, String>("hellotopic", "第"+i+"哟餐youcanyouup"), new Callback() {
//                @Override
//                public void onCompletion(RecordMetadata metadata, Exception e) {
//                    if (e != null) {
//                        e.printStackTrace();
//                    } else {
//                        System.out.println(metadata.toString());//org.apache.kafka.clients.producer.RecordMetadata@1d89e2b5
//                        System.out.println(metadata.offset());//1
//                    }
//                }
//            });
        }
//        producer.close();
//        producer.close();
    }
}
