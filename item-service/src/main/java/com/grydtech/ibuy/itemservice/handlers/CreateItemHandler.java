package com.grydtech.ibuy.itemservice.handlers;

import com.grydtech.ibuy.itemservice.events.ItemCreatedEvent;
import com.grydtech.ibuy.itemservice.requests.CreateItemRequest;
import com.grydtech.ibuy.itemservice.responses.GenericResponse;
import com.grydtech.msstack.core.CommandHandler;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/create-item")
public class CreateItemHandler implements CommandHandler<CreateItemRequest, GenericResponse> {

    @Override
    public GenericResponse handle(CreateItemRequest createItemRequest) {
        new ItemCreatedEvent(createItemRequest.getItemCode(), createItemRequest.getItemName()).emit();
        return new GenericResponse(200, "success");
    }
}
