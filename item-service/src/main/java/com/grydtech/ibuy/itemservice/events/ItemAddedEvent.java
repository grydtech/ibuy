package com.grydtech.ibuy.itemservice.events;

import com.grydtech.ibuy.itemservice.entities.ItemEntity;

public class ItemAddedEvent{
    private ItemEntity item;

    public ItemAddedEvent(ItemEntity item) {
        this.item = item;
    }

    public ItemEntity getItem() {
        return item;
    }
}