package com.finedietro.smartlightbackend.model;

public class Action {  // classe che mappa il json che viene mandato come body della chiamata POST fatta dal front End

    private String action;
    private String id;

    public Action() {
    }

    public Action(String action, String id) {
        this.action = action;
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
