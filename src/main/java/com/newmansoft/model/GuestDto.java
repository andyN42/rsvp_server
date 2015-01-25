package com.newmansoft.model;

/**
 * Created by user on 1/23/2015.
 */
public class GuestDto {

    private String firstName;
    private String lastName;
    private String id;
    private GuestDto plusOne;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public GuestDto getPlusOne() {
        return plusOne;
    }

    public void setPlusOne(GuestDto plusOne) {
        this.plusOne = plusOne;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
