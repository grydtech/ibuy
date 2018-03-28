package com.grydtech.ibuy.orderservice.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class KafkaHelper {
    private static ObjectMapper objectMapper;
    private static KafkaProducer<String, String> kafkaProducer;

    static {
        objectMapper = new ObjectMapper();

        try (InputStream props = KafkaHelper.class.getResource("producer.properties").openStream()) {
            Properties properties = new Properties();
            properties.load(props);
            kafkaProducer = new KafkaProducer<>(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void send(String topic, Object object) throws InvalidMessageBodyException {
        try {
            kafkaProducer.send(new ProducerRecord<>(topic, objectMapper.writeValueAsString(object)));
        } catch (JsonProcessingException e) {
            throw new InvalidMessageBodyException("cannot parse object to json");
        }
        kafkaProducer.flush();
    }
}
