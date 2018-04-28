package com.grydtech.ibuy.itemservice.entities;


import com.grydtech.ibuy.itemservice.events.ItemCreatedEvent;

public class ItemEntity {
    private String itemCode;
    private String itemName;

    public String getItemCode() {
        return itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void apply(ItemCreatedEvent itemCreatedEvent) {
        this.itemCode = itemCreatedEvent.getItemCode();
        this.itemName = itemCreatedEvent.getItemName();
    }

}
