package com.grydtech.ibuy.orderservice;

import com.grydtech.msstack.core.MSStackRunner;
import com.grydtech.msstack.core.jersey.JerseyApplication;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class OrderServiceApplication extends JerseyApplication {

    public static void main(String[] args) {
        MSStackRunner.run(OrderServiceApplication.class);
    }
}
