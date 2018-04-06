package com.grydtech.ibuy.itemservice.entities;

import com.grydtech.ibuy.itemservice.events.ItemCreatedEvent;

public class ItemEntity {
    private String itemCode;
    private String name;
    private Integer quantity;
    private Double unitPrice;
    private Double price;

    public String getItemCode() {
        return itemCode;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public Double getPrice() {
        return price;
    }

    public void apply(ItemCreatedEvent itemCreatedEvent) {
        this.itemCode = itemCreatedEvent.getItemCode();
        this.name = itemCreatedEvent.getName();
    }

}
