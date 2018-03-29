package com.grydtech.ibuy.orderservice.events;

import com.grydtech.ibuy.orderservice.common.Event;
import com.grydtech.ibuy.orderservice.common.Topic;
import com.grydtech.ibuy.orderservice.entities.ItemEntity;

@Topic("item-added")
public class ItemAddedEvent extends Event {
    private ItemEntity item;

    public ItemAddedEvent(ItemEntity item) {
        this.item = item;
    }

    public ItemEntity getItem() {
        return item;
    }
}