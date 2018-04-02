package com.grydtech.ibuy.itemservice.requests;

/**
 * Created by Gavindya on 3/29/2018.
 */
public class GetItemRequest implements Request {
    private String item;

    public GetItemRequest(String item) {
        this.item = item;
    }

    public GetItemRequest() {
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "GetItemRequest{" +
                "item='" + item + '\'' +
                '}';
    }
}
