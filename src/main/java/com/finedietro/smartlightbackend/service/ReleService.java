package com.finedietro.smartlightbackend.service;

import com.finedietro.smartlightbackend.connections.ReleConnection;
import com.finedietro.smartlightbackend.model.Rele;

public class ReleService {

    private Rele rele;
    private static String STATUS_ON = "ON";
    private static String STATUS_OFF = "OFF";
    private static String STATUS_ERROR = "ERROR";
    private static String ACTION_ACCENDI = "ACCENDI";
    private static String ACTION_SPEGNI = "SPEGNI";

    ReleConnection rl = new ReleConnection();
    
    public ReleService(String idBulbConnected) {

        rele = new Rele(idBulbConnected);

    }

    public Rele getReleStatus(String idBulb) {

        // viene chiamato il rele fisico facendo le relative chiamate http per ottenere lo stato dell'interruttore
        try {
           rele=  rl.getReleStatus();
            
        } catch (Exception e) {
            
            rele.setMessage(e.getMessage());
           
        }

        if (rele.getStatus().equalsIgnoreCase(STATUS_ERROR)) { //ERRORE
            return rele;

        } else if (rele.getStatus().equalsIgnoreCase(STATUS_ON)) {       // caso in cui rele rilevi contatto chiuso (passa corrente)
            rele.setStatus(STATUS_ON);

        } else if (rele.getStatus().equalsIgnoreCase(STATUS_ON)) {
            rele.setStatus(STATUS_OFF);
        }
        return rele;
        
    }

    public Rele setReleStatus(String idBulb, String action) {

        
        
        if (action.equalsIgnoreCase(ACTION_ACCENDI)) {
            
        } else if (action.equalsIgnoreCase(ACTION_SPEGNI)) {

        }
        
          try {
                // chiamo il rele e con richiesta http chiedo di accendere o spegnere
            } catch (Exception e) {
                rele.setStatus(e.getMessage());
            }
 
        
        return rele;

    }

}
