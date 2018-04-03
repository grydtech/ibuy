package com.grydtech.ibuy.orderservice.entities;

import com.grydtech.ibuy.orderservice.events.ItemAddedEvent;
import com.grydtech.ibuy.orderservice.events.OrderCreatedEvent;
import com.grydtech.ibuy.orderservice.events.OrderFinalizedEvent;
import com.grydtech.msstack.core.components.Entity;

import java.util.List;

public class OrderEntity extends Entity {
    private String orderId;
    private String customerId;
    private Double payment;
    private List<ItemEntity> items;

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public Double getPayment() {
        return payment;
    }

    public List<ItemEntity> getItems() {
        return items;
    }

    public void apply(OrderCreatedEvent orderCreatedEvent) {
        // add OrderCreatedEvent based logic here
    }

    public void apply(ItemAddedEvent itemAddedEvent) {
        // add ItemAddedEvent based logic here
    }

    public void apply(OrderFinalizedEvent orderFinalizedEvent) {
        // add OrderFinalizedEvent based logic here
    }
}
