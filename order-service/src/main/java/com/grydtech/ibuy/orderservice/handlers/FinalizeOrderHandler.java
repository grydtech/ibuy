package com.grydtech.ibuy.orderservice.handlers;

import com.grydtech.ibuy.orderservice.events.OrderFinalizedEvent;
import com.grydtech.ibuy.orderservice.requests.OrderFinalizeRequest;
import com.grydtech.ibuy.orderservice.responses.GenericResponse;
import com.grydtech.msstack.core.components.handlers.CommandHandler;

import javax.ws.rs.Path;

@Path("/finalize-order")
public class FinalizeOrderHandler implements CommandHandler<OrderFinalizeRequest, GenericResponse> {

    public GenericResponse handle(OrderFinalizeRequest orderFinalizeRequest) {
        new OrderFinalizedEvent(orderFinalizeRequest.getOrderId(), orderFinalizeRequest.getPayment()).emit();
        return new GenericResponse(200, "success");
    }

}