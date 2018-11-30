package com.finedietro.smartlightbackend.connections;

import com.finedietro.smartlightbackend.model.Rele;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class ReleConnection {

    private URL url;
    private HttpURLConnection connection;
    private Rele rele;

    public Rele getReleStatus() {

        System.out.println("Sono in getReleStatus di ReleConnection");

        try {
            Client client = ClientBuilder.newClient();
            // In un oggetto WebTarget viene indicato il target della richiesta HTTP
            WebTarget target = client.target("http://localhost:8080/dev-backend-reloaded/smartlight/lightbulb/testRele");
            // Viene effettuata la richiesta la quale ritorna un JSON, successivamente viene convertito nella class Rele
            rele = target.request(MediaType.APPLICATION_JSON).get(Rele.class);
            System.out.println("Sono alla fine del try()");
        } catch (Exception error) {
            rele.setMessage(error.getMessage());
            System.out.println("Eccezione : " + error);
        }

        return rele;

    }

}
