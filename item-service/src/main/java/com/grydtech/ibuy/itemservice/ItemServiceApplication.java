package com.grydtech.ibuy.itemservice;

import com.grydtech.msstack.core.MicroserviceRunner;
import com.grydtech.msstack.core.annotations.Microservice;
import com.grydtech.msstack.microservices.jersey.JerseyApplication;

import javax.ws.rs.ApplicationPath;

@Microservice(port = "4001")
@ApplicationPath("/")
public class ItemServiceApplication extends JerseyApplication {

    public static void main(String[] args) throws Exception {
        MicroserviceRunner.run(ItemServiceApplication.class);
    }
}
