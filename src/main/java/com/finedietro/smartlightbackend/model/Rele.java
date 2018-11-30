package com.finedietro.smartlightbackend.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Rele {

    private String idBulb;
    private String status;
    private String message;

    public Rele(String idBulb) {
        this.idBulb = idBulb;
    }

    public Rele() {
    }

    public String getIdBulb() {
        return idBulb;
    }

    public void setIdBulb(String idBulb) {
        this.idBulb = idBulb;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
