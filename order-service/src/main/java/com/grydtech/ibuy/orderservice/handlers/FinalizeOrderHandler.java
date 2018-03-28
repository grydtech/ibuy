package com.grydtech.ibuy.orderservice.handlers;

import com.grydtech.ibuy.orderservice.events.*;
import com.grydtech.ibuy.orderservice.requests.*;
import com.grydtech.ibuy.orderservice.responses.*;

public class FinalizeOrderHandler {

    public GenericResponse handle(AddItemRequest addItemRequest) {
        // add logic before OrderFinalizedEvent emit
        OrderFinalizedEvent orderFinalizedEvent = new OrderFinalizedEvent();
        // add logic after OrderFinalizedEvent emit
        return new GenericResponse(200, "success");
    }

}