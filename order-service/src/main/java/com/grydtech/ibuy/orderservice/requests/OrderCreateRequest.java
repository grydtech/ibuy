package com.grydtech.ibuy.orderservice.requests;

import com.grydtech.msstack.core.components.Request;

public class OrderCreateRequest extends Request {
    private String customerId;

    public String getCustomerId() {
        return customerId;
    }
}
