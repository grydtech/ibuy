package com.grydtech.ibuy.orderservice.handlers;

import com.grydtech.ibuy.orderservice.events.*;
import com.grydtech.ibuy.orderservice.requests.*;
import com.grydtech.ibuy.orderservice.responses.*;

public class AddItemHandler {

    public GenericResponse handle(AddItemRequest addItemRequest) {
        // add logic before ItemAddedEvent emit
        ItemAddedEvent itemAddedEvent = new ItemAddedEvent();
        // add logic after ItemAddedEvent emit
        return new GenericResponse(200, "success");
    }

}