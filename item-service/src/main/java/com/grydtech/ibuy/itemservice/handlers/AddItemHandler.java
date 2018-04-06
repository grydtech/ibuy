package com.grydtech.ibuy.itemservice.handlers;

import com.grydtech.ibuy.itemservice.requests.AddItemRequest;
import com.grydtech.ibuy.itemservice.responses.GenericResponse;
import com.grydtech.msstack.core.CommandHandler;


public class AddItemHandler implements CommandHandler<AddItemRequest,GenericResponse >{

    public AddItemHandler() {
    }

    @Override
    public GenericResponse handle(AddItemRequest addItemRequest) {
        return new GenericResponse(200,"ADD item Success");
    }

}