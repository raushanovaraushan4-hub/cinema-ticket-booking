package org.example;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class Main {
    public static final String BASE_URI = "http://localhost:8080/api/";

    public static void main(String[] args) {
        try {
            final ResourceConfig rc = new ResourceConfig().packages("org.example.api");

            HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);

            System.out.println("Server started at " + BASE_URI);
            System.out.println("Press Ctrl+C to stop...");

            Thread.currentThread().join();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
