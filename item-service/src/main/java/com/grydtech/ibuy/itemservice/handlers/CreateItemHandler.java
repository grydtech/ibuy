package com.grydtech.ibuy.itemservice.handlers;

import com.grydtech.ibuy.itemservice.events.ItemCreatedEvent;
import com.grydtech.ibuy.itemservice.requests.CreateItemRequest;
import com.grydtech.ibuy.itemservice.responses.GenericResponse;
import com.grydtech.msstack.core.CommandHandler;
import com.grydtech.msstack.core.annotations.Handler;

import javax.ws.rs.Path;

@Handler
@Path("/create-order")
public class CreateItemHandler implements CommandHandler<CreateItemRequest, GenericResponse> {
    
    public GenericResponse handle(CreateItemRequest createItemRequest) {
        new ItemCreatedEvent(createItemRequest.getItemCode(), createItemRequest.getName()).emit();
        return new GenericResponse(200, "success");
    }

}