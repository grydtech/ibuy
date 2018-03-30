package com.grydtech.ibuy.orderservice.handlers;

import com.grydtech.ibuy.orderservice.requests.AddItemRequest;
import com.grydtech.ibuy.orderservice.responses.GenericResponse;

public class AddItemHandler {

    public GenericResponse handle(AddItemRequest addItemRequest) {
        return new GenericResponse(200, "success");
    }

}