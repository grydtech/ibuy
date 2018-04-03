package com.grydtech.msstack.core.components.handlers;

import com.grydtech.msstack.core.components.Request;
import com.grydtech.msstack.core.components.Response;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public interface QueryHandler<R extends Request, S extends Response> extends Handler<R, S> {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    S handle(R request);
}
