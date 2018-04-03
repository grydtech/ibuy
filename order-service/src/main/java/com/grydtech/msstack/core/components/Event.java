package com.grydtech.msstack.core.components;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.grydtech.msstack.transport.KafkaHelper;

public abstract class Event {
    public void emit() {
        try {
            String topic = getClass().getName();
            KafkaHelper.send(topic, this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
