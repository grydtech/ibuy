package com.grydtech.ibuy.orderservice;

import com.grydtech.ibuy.orderservice.handlers.CreateOrderHandler;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class OrderServiceApp extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        return new HashSet<>(
                Arrays.asList(
                        CreateOrderHandler.class,
                        JacksonFeature.class
                ));
    }
}
