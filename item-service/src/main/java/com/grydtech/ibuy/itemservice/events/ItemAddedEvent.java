package com.grydtech.ibuy.itemservice.events;

import com.grydtech.ibuy.itemservice.common.Event;
import com.grydtech.ibuy.itemservice.entities.ItemEntity;

public class ItemAddedEvent extends Event {
    private ItemEntity item;

    public ItemAddedEvent(ItemEntity item) {
        this.item = item;
    }

    public ItemEntity getItem() {
        return item;
    }
}