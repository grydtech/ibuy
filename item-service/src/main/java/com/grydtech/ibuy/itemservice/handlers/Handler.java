package com.grydtech.ibuy.itemservice.handlers;

/**
 * Created by Gavindya on 4/1/2018.
 */
public interface Handler<Request,Response> {
    Response handle(Request request);
}
