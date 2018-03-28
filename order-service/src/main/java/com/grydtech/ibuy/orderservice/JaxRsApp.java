package com.grydtech.ibuy.orderservice;

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class JaxRsApp {
    // Base URI the Grizzly HTTP server will listen on
    private static final String BASE_URI = "http://localhost:8080/";

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     */
    private static void startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        final ResourceConfig rc = new ResourceConfig().packages("com.grydtech.ibuy.orderservice.handlers");

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    /**
     * Main method.
     * @param args program arguments
     */
    public static void main(String[] args) {
        startServer();
        System.out.println(String.format("Jersey app started on %s", BASE_URI));
    }
}
