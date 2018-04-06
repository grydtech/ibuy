package com.grydtech.ibuy.itemservice.handlers;

import com.grydtech.ibuy.itemservice.requests.GetItemRequest;
import com.grydtech.ibuy.itemservice.responses.GenericResponse;
import com.grydtech.msstack.core.QueryHandler;

public class GetItemHandler implements QueryHandler<GetItemRequest,GenericResponse> {

    public GetItemHandler() {
    }

    public GenericResponse handle(GetItemRequest getItemRequest)
    {
        return new GenericResponse(200, "GET item Success");
    }
}
