package com.grydtech.ibuy.orderservice.handlers;

import com.grydtech.ibuy.orderservice.events.OrderItemAddedEvent;
import com.grydtech.ibuy.orderservice.requests.AddOrderItemRequest;
import com.grydtech.ibuy.orderservice.responses.GenericResponse;
import com.grydtech.msstack.core.components.handlers.CommandHandler;

import javax.ws.rs.Path;

@Path("/add-order-item")
public class AddOrderItemHandler implements CommandHandler<AddOrderItemRequest, GenericResponse> {

    public GenericResponse handle(AddOrderItemRequest addOrderItemRequest) {
        new OrderItemAddedEvent(addOrderItemRequest.getOrderId(), addOrderItemRequest.getItemEntity()).emit();
        return new GenericResponse(200, "success");
    }

}