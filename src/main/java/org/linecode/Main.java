package org.linecode;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

/**
 * Main class.
 *
 */
public class Main {
    // Base URI the Grizzly HTTP server will listen on.
    // ATTENZIONE: url cambiato da localhost a 0.0.0.0 per funzionare all'interno
    // di un container docker. Fonte: https://yurisubach.com/2016/07/14/jersey-dockerize/
    public static final String BASE_URI = "http://0.0.0.0:8080/myapp/";

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in org.linecode package
        final ResourceConfig rc = new ResourceConfig().packages("org.linecode");

        // La registrazione manuale del file JacksonFeature.class nel ResourceConfig
        // del web-server è necessaria per creare .jar standalone con maven-assembly-plugin
        // con il supporto per JSON dato dalla libreria Jackson
        // Fonte: https://stackoverflow.com/questions/33921252/jax-rs-messagebodywriter-not-found-for-media-type-application-json-executing-j
        rc.register(JacksonFeature.class);

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    /**
     * Main method.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();
        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
        System.in.read();
        server.stop();
    }
}

