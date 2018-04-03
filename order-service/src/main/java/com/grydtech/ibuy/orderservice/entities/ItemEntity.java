package com.grydtech.ibuy.orderservice.entities;

import com.grydtech.msstack.core.components.Entity;

public class ItemEntity extends Entity {
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


}
