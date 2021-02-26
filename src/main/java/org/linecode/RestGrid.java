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
    public List<Cell> returnGrid() {
        List<Cell> l = new ArrayList<Cell>();
        for (int x = 0; x < Main.map.getLenght(); ++x )
            for (int y = 0; y < Main.map.getHeight(); ++y) // TODO: Chiedere ad Aledindo se preferisce per righe o per colonne.
                l.add(Main.map.getCell(x,y));
        return l;
    }

}
