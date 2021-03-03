package org.linecode;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

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

        for (int y = 0; y < Main.map.getHeight(); ++y) {
            for (int x = 0; x < Main.map.getLength(); ++x) {
                l.add(Main.map.getCell(x, y));
            }
        }

        System.out.println("Requested current grid through HTTP GET");

        return l;
    }
}
