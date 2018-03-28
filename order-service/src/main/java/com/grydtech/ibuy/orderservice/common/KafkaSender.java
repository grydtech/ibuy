package com.grydtech.ibuy.orderservice.common;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class KafkaSender {
//    private KafkaProducer<String, String> kafkaProducer;

//    public KafkaSender() {
//        try {
//            ClassLoader loader = Thread.currentThread().getContextClassLoader();
//            InputStream stream = loader.getResourceAsStream("/producer.properties");
//            Properties properties = new Properties();
//            properties.load(stream);
//            this.kafkaProducer = new KafkaProducer<>(properties);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public void send(String topic, String message) {
//        this.kafkaProducer.send(new ProducerRecord<>(topic, message));
//        this.kafkaProducer.flush();
    }
}
