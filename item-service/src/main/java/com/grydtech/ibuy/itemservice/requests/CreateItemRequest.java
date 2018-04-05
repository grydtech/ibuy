package com.grydtech.ibuy.itemservice.requests;

import com.grydtech.msstack.core.Request;

public class CreateItemRequest extends Request {
    private String itemCode;
    private String name;

    public String getItemCode() {
        return itemCode;
    }

    public String getName() {
        return name;
    }
}