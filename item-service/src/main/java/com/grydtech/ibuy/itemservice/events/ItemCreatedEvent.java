package com.grydtech.ibuy.itemservice.events;

import com.grydtech.msstack.core.Event;

public class ItemCreatedEvent extends Event {
    private String itemCode;
    private String itemName;

    public ItemCreatedEvent(String itemCode, String itemName) {
        this.itemCode = itemCode;
        this.itemName = itemName;
    }

    public String getItemCode() {
        return itemCode;
    }

    public String getItemName() {
        return itemName;
    }
}