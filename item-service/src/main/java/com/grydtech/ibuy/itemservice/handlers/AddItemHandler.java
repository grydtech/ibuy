package com.grydtech.ibuy.itemservice.handlers;

import com.grydtech.ibuy.itemservice.requests.AddItemRequest;
import com.grydtech.ibuy.itemservice.responses.GenericResponse;


public class AddItemHandler implements Handler<AddItemRequest, GenericResponse>{

    @Override
    public GenericResponse handle(AddItemRequest addItemRequest) {
        return new GenericResponse(200,"ADD item Success");
    }

}