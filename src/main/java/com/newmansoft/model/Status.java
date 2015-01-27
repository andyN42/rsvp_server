package com.newmansoft.model;

/**
 * Created by andyn on 1/26/2015.
 */
public class Status {

    private Long id;
    private String value;
    public  Status() {

    }

    public Status(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
