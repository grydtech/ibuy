package com.grydtech.ibuy.orderservice.common;

public final class KafkaHelper {
    private static KafkaSender kafkaSender;

    static {
        kafkaSender = new KafkaSender();
    }

    private KafkaHelper(){}

    public static void send(String topic, String message) {
        kafkaSender.send(topic, message);
    }
}
