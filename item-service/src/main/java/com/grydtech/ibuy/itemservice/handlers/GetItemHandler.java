package com.grydtech.ibuy.itemservice.handlers;

import com.grydtech.ibuy.itemservice.requests.GetItemRequest;
import com.grydtech.ibuy.itemservice.responses.GenericResponse;

public class GetItemHandler implements Handler<GetItemRequest,GenericResponse> {

    public GenericResponse handle(GetItemRequest getItemRequest)
    {
        return new GenericResponse(200, "GET item Success");
    }
}
