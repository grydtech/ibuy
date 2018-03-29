package com.grydtech.ibuy.orderservice.handlers;

import com.grydtech.ibuy.orderservice.requests.*;
import com.grydtech.ibuy.orderservice.responses.*;

public class AddItemHandler {

    public GenericResponse handle(AddItemRequest addItemRequest) {
        return new GenericResponse(200, "success");
    }

}