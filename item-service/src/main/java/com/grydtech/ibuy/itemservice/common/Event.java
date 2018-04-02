package com.grydtech.ibuy.itemservice.common;

//import com.fasterxml.jackson.core.JsonProcessingException;

public abstract class Event {
    public void emit() {
        try {
            Topic annotation = this.getClass().getDeclaredAnnotation(Topic.class);
//            KafkaHelper.send(annotation.value(), this);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
