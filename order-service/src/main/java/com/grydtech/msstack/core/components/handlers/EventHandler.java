package com.grydtech.msstack.core.components.handlers;

import com.grydtech.msstack.core.components.Event;

public interface EventHandler<E extends Event> extends Handler<E, Void> {
    @Override
    Void handle(E event);
}
