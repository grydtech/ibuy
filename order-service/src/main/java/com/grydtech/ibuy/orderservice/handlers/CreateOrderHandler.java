package com.grydtech.ibuy.orderservice.handlers;

import com.grydtech.ibuy.orderservice.events.OrderCreatedEvent;
import com.grydtech.ibuy.orderservice.requests.OrderCreateRequest;
import com.grydtech.ibuy.orderservice.responses.GenericResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/orders")
public class CreateOrderHandler {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public GenericResponse handle(OrderCreateRequest orderCreateRequest) {
        new OrderCreatedEvent(orderCreateRequest.getCustomerId()).emit();
        return new GenericResponse(200, "success");
    }

}