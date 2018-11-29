package com.finedietro.smartlightbackend.service;

import com.finedietro.smartlightbackend.model.Action;
import com.finedietro.smartlightbackend.model.Lightbulb;
import com.finedietro.smartlightbackend.model.Rele;

/**
 *
 * @author aless
 */
public class LightbulbService {

    private Lightbulb lightbulb;
    private ReleService rs;
    private MeterService ms;
    private Rele rele;

    private static String STATUS_ON = "ON";
    private static String STATUS_OFF = "OFF";
    private static String STATUS_ERROR = "ERROR";
    private static String ACTION_ACCENDI = "ACCENDI";
    private static String STATUS_SPEGNI = "SPEGNI";

    public LightbulbService() {
        this.lightbulb = new Lightbulb();
        this.ms = new MeterService();
    }
    

    private String checkReleStatus(String id) {   // DA FARE !!!!!!!!!
        rs = new ReleService(id);
        
        rele = rs.getReleStatus(id);
        
        if (rele.getStatus().equalsIgnoreCase(STATUS_ON)) {
            return STATUS_ON;
        } else if (rele.getStatus().equalsIgnoreCase(STATUS_OFF)) {
            return STATUS_OFF;
        } else {
            if(rele.getMessage()!= null){
                lightbulb.setMessage(rele.getMessage());
            }
            return STATUS_ERROR;
            
        }

    }

    public Lightbulb manageAction(Action action) {
        if (action.getAction().equalsIgnoreCase(ACTION_ACCENDI)) {
            lightbulb.setId(action.getId());
            lightbulb.setStatus(STATUS_ON);
        } else if (action.getAction().equalsIgnoreCase(STATUS_SPEGNI)) {
            lightbulb.setStatus(STATUS_OFF);
        } else {
            lightbulb.setStatus(STATUS_ERROR);
            lightbulb.setMessage("Azione non esistente");
        }
        return lightbulb;
    }

    public Lightbulb getLightbulbStatus(String id) {

        lightbulb.setId(id);
        
        lightbulb.setStatus(checkReleStatus(id));

        return lightbulb;
    }

    public Lightbulb getLightbulb() {
        return lightbulb;
    }

    public void setLightbulb(Lightbulb lightbulb) {
        this.lightbulb = lightbulb;
    }

}
