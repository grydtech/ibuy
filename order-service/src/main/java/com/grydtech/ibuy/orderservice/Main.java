package com.grydtech.ibuy.orderservice;

import com.grydtech.ibuy.orderservice.common.JettyRunner;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.CommonProperties;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public class Main {

    public static void main(String[] args) throws Exception {
        ServletContainer jerseyServlet = new ServletContainer(ResourceConfig.forApplicationClass(OrderServiceApp.class));
        ServletHolder holder = new ServletHolder(jerseyServlet);
        holder.setInitParameter(CommonProperties.METAINF_SERVICES_LOOKUP_DISABLE, "true");

        new JettyRunner(8080, "/", holder).run();
    }
}
