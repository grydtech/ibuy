package com.grydtech.ibuy.itemservice.requests;

import com.grydtech.msstack.core.Request;

/**
 * Created by Gavindya on 3/29/2018.
 */
public class GetItemRequest extends Request {
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
