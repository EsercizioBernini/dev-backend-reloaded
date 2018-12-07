package com.finedietro.smartlightbackend.resurces;

import com.finedietro.smartlightbackend.model.Action;
import com.finedietro.smartlightbackend.model.Lightbulb;
import com.finedietro.smartlightbackend.service.LightbulbService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("lightbulb")
public class LightbulbResurce {

    LightbulbService ls = new LightbulbService();

    @GET
    @Path("/{id}/status")
    @Produces(MediaType.APPLICATION_JSON)
    public Lightbulb getLightbulbStatus(@PathParam("id") String id) {
        return ls.getLightbulbStatus(id);
    }

    @POST
    @Path("/action")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Lightbulb setLightbulbStatus(Action action) {
       
        return ls.manageAction(action);
    }

}
