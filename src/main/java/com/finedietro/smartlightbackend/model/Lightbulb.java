package com.finedietro.smartlightbackend.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aless
 */
@XmlRootElement
public class Lightbulb {

    private String id;
    private String status;
    private String message;

    public Lightbulb(String id) {
        this.id = id;
    }

    public Lightbulb() {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
