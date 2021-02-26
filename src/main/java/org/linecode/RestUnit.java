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
@Path("unit")
public class RestUnit {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Position> createProductInJSON(UnitInfo update) {

        if(update.isPath()){
            //TODO: Calcola Array List
            List<Position> l = new ArrayList<Position>();
            l.add(new Position(1,1));
            l.add(new Position(1,2));
            return l;
        }
        return null;
    }

}