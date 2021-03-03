package org.linecode;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.core.MultivaluedMap;

import java.io.IOException;

/**
 * Classe che permette di ritornare l'header CORS:
 * Access-Control-Allow-Origin: *
 *
 * Fonte: https://www.codepedia.org/ama/how-to-add-cors-support-on-the-server-side-in-java-with-jersey/
 */
public class CORSResponseFilter implements ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
            throws IOException {

        MultivaluedMap<String, Object> headers = responseContext.getHeaders();

        headers.add("Access-Control-Allow-Origin", "*");
        //headers.add("Access-Control-Allow-Origin", "https://podcastpedia.org"); //allows CORS requests only coming from podcastpedia.org
        //headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
        //headers.add("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, X-Codingpedia");
    }
}
