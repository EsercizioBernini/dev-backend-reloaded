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
    private static String STATUS_0 = "0";
    private static String STATUS_1 = "1";
    private static String STATUS_ERROR = "ERROR";
    private static String ACTION_ACCENDI = "ACCESO";
    private static String ACTION_SPEGNI = "SPENTO";

    public LightbulbService() {
        this.lightbulb = new Lightbulb();
        this.ms = new MeterService();
    }

    private String checkReleStatus(String id) {  
        rs = new ReleService(id);

        rele = rs.getReleStatus(id);

        if (rele.getStatus().equalsIgnoreCase(STATUS_1)) {
            return STATUS_ON;
        } else if (rele.getStatus().equalsIgnoreCase(STATUS_0)) {
            return STATUS_OFF;
        } else {
            if (rele.getStatus().equalsIgnoreCase(STATUS_ERROR)) {
                lightbulb.setMessage(rele.getMessage());
            }
            return STATUS_ERROR;

        }
    }

    public Lightbulb manageAction(Action action) {
        lightbulb.setId(action.getId());
        if (action.getAction().equalsIgnoreCase(ACTION_ACCENDI) || action.getAction().equalsIgnoreCase(ACTION_SPEGNI)) {
            
            rs = new ReleService(action.getId());
            rele = rs.setReleStatus(action);
        } else {
            lightbulb.setStatus(STATUS_ERROR);
            lightbulb.setMessage("Azione non presente");
            return lightbulb;
        }

        if (rele.getStatus().equalsIgnoreCase(STATUS_1)) {
            lightbulb.setStatus(STATUS_ON);
        } else if (rele.getStatus().equalsIgnoreCase(STATUS_0)) {
            lightbulb.setStatus(STATUS_OFF);
        } else if(rele.getStatus().equalsIgnoreCase(STATUS_ERROR)){
            lightbulb.setStatus(STATUS_ERROR);
            lightbulb.setMessage(rele.getMessage());
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
