package com.grydtech.ibuy.orderservice.common;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.lang.annotation.Annotation;

public abstract class Event {
    public void emit() {
        try {
            Topic annotation = this.getClass().getDeclaredAnnotation(Topic.class);
            KafkaHelper.send(annotation.value(), this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
