package com.grydtech.ibuy.orderservice.common;

public abstract class Event {
    public void emit() {
        try {
            KafkaHelper.send("order-created", this);
        } catch (InvalidMessageBodyException e) {
            e.printStackTrace();
        }
    }
}
