package com.grydtech.ibuy.itemservice.handlers;

import com.grydtech.ibuy.itemservice.requests.Request;
import com.grydtech.ibuy.itemservice.responses.GenericResponse;

/**
 * Created by Gavindya on 4/1/2018.
 */
public class NotFoundHandler implements Handler<Request, GenericResponse> {

    @Override
    public GenericResponse handle(Request request) {
        return new GenericResponse(404, "Not Found");
    }
}
