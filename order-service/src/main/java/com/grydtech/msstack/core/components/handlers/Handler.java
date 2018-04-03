package com.grydtech.msstack.core.components.handlers;

public interface Handler<R, S> {
    S handle(R request);
}
