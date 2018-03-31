package com.grydtech.ibuy.orderservice.common;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class JettyRunner {
    private Server server;

    public JettyRunner(Integer port, String contextPath, ServletHolder servletHolder) {
        this.server = new Server(port);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath(contextPath);
        context.addServlet(servletHolder, "/*");
        this.server.setHandler(context);
    }

    public void run() throws Exception {
        try {
            this.server.start();
            this.server.join();
        } finally {
            this.server.destroy();
        }
    }

    public void stop() {
        this.server.destroy();
    }
}
