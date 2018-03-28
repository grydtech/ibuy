package com.grydtech.ibuy.orderservice.common;

public abstract class Event {
    public void emit() {
        KafkaHelper.send("order-created", "test");
    }
}
