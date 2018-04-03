package com.grydtech.msstack.core.components;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.base.CaseFormat;
import com.grydtech.msstack.transport.KafkaHelper;

public abstract class Event {
    public void emit() {
        try {
            String topic = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_HYPHEN, getClass().getSimpleName());
            KafkaHelper.send(topic, this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
