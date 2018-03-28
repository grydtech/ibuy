package com.grydtech.ibuy.orderservice.handlers;

import com.grydtech.ibuy.orderservice.events.*;
import com.grydtech.ibuy.orderservice.requests.*;
import com.grydtech.ibuy.orderservice.responses.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/orders")
@Consumes("application/json")
@Produces("application/json")
public class CreateOrderHandler {

    @POST
    public GenericResponse handle(OrderCreateRequest orderCreateRequest) {
        // add logic before OrderCreatedEvent emit
        OrderCreatedEvent orderCreatedEvent = new OrderCreatedEvent();
        // add logic after OrderCreatedEvent emit
        return new GenericResponse(200, "success");
    }

}