package com.grydtech.ibuy.itemservice.requests;


public class AddItemRequest implements Request {

    private String itemId;
    private int qty;
    private String len;

    public String getItemId() {
        return itemId;
    }
    public int getItemQty() { return qty; }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getLen() {
        return len;
    }

    public void setLen(String len) {
        this.len = len;
    }
}