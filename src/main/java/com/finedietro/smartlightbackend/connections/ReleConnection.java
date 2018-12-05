package com.finedietro.smartlightbackend.connections;

import com.finedietro.smartlightbackend.model.Action;
import com.finedietro.smartlightbackend.model.Rele;

import java.net.HttpURLConnection;

import java.net.URL;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class ReleConnection {

    private URL url;
    private HttpURLConnection connection;
    private Rele rele= new Rele();
    
                                                                                

    public Rele getReleStatus() {

        System.out.println("Sono in getReleStatus di ReleConnection");          

        try {
            Client client = ClientBuilder.newClient();
            // In un oggetto WebTarget viene indicato il target della richiesta HTTP
            WebTarget target = client.target("http://192.168.0.72:8084/webapi/GestioneLuce/");
            //http://192.168.0.72:8084/webapi/GestioneLuce/
            //http://localhost:8080/testwebapp/webapi/rele/001/status
            // Viene effettuata la richiesta la quale ritorna un JSON, successivamente viene convertito nella class Rele
            rele = target.request(MediaType.APPLICATION_JSON).get(Rele.class);
            System.out.println("Rele tornato: " + rele.getMessage() +" "+ rele.getId());
            System.out.println("Sono alla fine del try()");
        } catch (Exception error) {
            rele.setMessage(error.getMessage());
            System.out.println("Eccezione : " + error);
        }
        
        return rele;

    }
    
    public Rele setReleStatus(Action action) {
        
        return rele;
    }

}
