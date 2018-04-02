//package com.grydtech.ibuy.itemservice.common;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//
//public final class KafkaHelper {
//    private static KafkaSender kafkaSender;
//
//    static {
//        kafkaSender = new KafkaSender();
//    }
//
//    private KafkaHelper(){}
//
//    public static void send(String topic, Object content) throws JsonProcessingException {
//        kafkaSender.send(topic, content);
//    }
//}
