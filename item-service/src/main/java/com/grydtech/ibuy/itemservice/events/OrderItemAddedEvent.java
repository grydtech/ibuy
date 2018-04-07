package com.grydtech.ibuy.itemservice.events;

import com.grydtech.ibuy.itemservice.entities.ItemEntity;
import com.grydtech.msstack.core.Event;

public class OrderItemAddedEvent extends Event {
    private String orderId;
    private ItemEntity item;

    public OrderItemAddedEvent(String orderId, ItemEntity item) {
        this.orderId = orderId;
        this.item = item;
    }

    public String getOrderId() {
        return orderId;
    }

    public ItemEntity getItem() {
        return item;
    }
}