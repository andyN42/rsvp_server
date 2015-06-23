package com.newmansoft.model;

/**
 * Created by andyn on 6/5/2015.
 */
public class EmailDto {
    private String subject;
    private String body;
    private String address;


    public EmailDto() {
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
