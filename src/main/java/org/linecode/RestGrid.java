package org.linecode;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * Root resource (exposed at "grid" path)
 */
@Path("grid")
public class RestGrid {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Grid returnGrid() {
        return Main.map;  // TODO: Ricordati di creare una Lista contenente tutte le info di Cell[][] dentro map.
    }


/*
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createProductInJSON(Product product) {

        String result = "Product created: " + product;

        return Response.status(201).entity(result).build();
    }
   */

}
