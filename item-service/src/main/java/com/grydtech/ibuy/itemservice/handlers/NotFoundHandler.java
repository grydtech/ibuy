package com.grydtech.ibuy.itemservice.handlers;

import com.grydtech.ibuy.itemservice.responses.GenericResponse;
import com.grydtech.msstack.core.CommandHandler;
import com.grydtech.msstack.core.Request;

/**
 * Created by Gavindya on 4/1/2018.
 */
public class NotFoundHandler implements CommandHandler<Request, GenericResponse> {

    @Override
    public GenericResponse handle(Request request) {
        return new GenericResponse(404, "Not Found");
    }
}
