package org.linecode;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MyResourceTest {

    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        // start the server
        server = Main.startServer();
        // create the client
        Client c = ClientBuilder.newClient();

        // uncomment the following line if you want to enable
        // support for JSON in the client (you also have to uncomment
        // dependency on jersey-media-json module in pom.xml and Main.startServer())
        // --
        // c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());

        target = c.target(Main.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    // Standard di nomenclatura dei test di Roy Osherove
    // Fonte: https://osherove.com/blog/2005/4/3/naming-standards-for-unit-tests.html

    @Test
    public void getProductInJSON_HttpGetWorksWithGrizzlyServerOn_returnsKnownJSONFile() {
        String responseMsg = target.path("myresource").request().get(String.class);
        assertEquals("{\"name\":\"iPad 3\",\"qty\":999}", responseMsg);
    }

    // TODO Aggiungere test per Http POST
}
