package com.grydtech.ibuy.itemservice.handlers;

import com.grydtech.ibuy.itemservice.requests.Request;
import com.grydtech.ibuy.itemservice.responses.Response;

/**
 * Created by Gavindya on 4/1/2018.
 */
public interface Handler<R extends Request, S extends Response> {
    S handle(R request);
}