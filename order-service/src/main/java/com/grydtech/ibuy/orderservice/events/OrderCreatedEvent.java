package com.grydtech.ibuy.orderservice.events;

import com.grydtech.ibuy.orderservice.common.Event;
import com.grydtech.ibuy.orderservice.common.Topic;

@Topic("order-created")
public class OrderCreatedEvent extends Event {
    private String customerId;

    public OrderCreatedEvent(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }
}