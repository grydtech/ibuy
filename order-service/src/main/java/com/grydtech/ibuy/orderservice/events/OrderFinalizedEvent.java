package com.grydtech.ibuy.orderservice.events;

import com.grydtech.ibuy.orderservice.common.Event;
import com.grydtech.ibuy.orderservice.common.Topic;

@Topic("order-finalized")
public class OrderFinalizedEvent extends Event {
    private Double payment;

    public OrderFinalizedEvent(Double payment) {
        this.payment = payment;
    }

    public Double getPayment() {
        return payment;
    }
}