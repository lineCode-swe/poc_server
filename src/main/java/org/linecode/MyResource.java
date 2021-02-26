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
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Product getProductInJSON() {
//
//        Product product = new Product();
//        product.setName("iPad 3");
//        product.setQty(999);
//
//        return product;
//    }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Product> returnInt() {
//        List<Product> l = new ArrayList<Product>(3);
//
//        Product a = new Product();
//        a.setName("iPhone");
//        a.setQty(3);
//
//        Product b = new Product();
//        b.setName("Samsung");
//        b.setQty(4);
//
//        Product c = new Product();
//        c.setName("Computer");
//        c.setQty(7);
//
//        l.add(a);
//        l.add(b);
//        l.add(c);
//
//        return l;
//    }

//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response createProductInJSON(Product product) {
//
//        String result = "Product created: " + product;
//
//        return Response.status(201).entity(result).build();
//    }
}
