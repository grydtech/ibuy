package com.grydtech.ibuy.itemservice.handlers;

import com.grydtech.ibuy.itemservice.events.OrderItemAddedEvent;
import com.grydtech.msstack.core.EventHandler;

public class OrderItemAddedHandler implements EventHandler<OrderItemAddedEvent> {

    @Override
    public Void handle(OrderItemAddedEvent orderItemAddedEvent) {
        return null;
    }
}
