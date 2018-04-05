package com.grydtech.ibuy.itemservice.events;

import com.grydtech.msstack.core.Event;

public class ItemCreatedEvent extends Event {

    private String itemCode;
    private String name;

    public ItemCreatedEvent(String itemCode, String name) {
        this.itemCode = itemCode;
        this.name = name;
    }

    public String getItemCode() {
        return itemCode;
    }

    public String getName() {
        return name;
    }
}