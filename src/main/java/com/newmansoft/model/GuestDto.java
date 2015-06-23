package com.newmansoft.model;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by user on 1/23/2015.
 */

public class GuestDto {

    private String firstName;
    private String lastName;

    private Long id;
    private String phoneNumber;
    private String address;
    private String notes;
    private Long   mealId;
    private Long statusId;
    private String association;
    private String partySize;

    private String email;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getAssociation() {
        return association;
    }

    public void setAssociation(String association) {
        this.association = association;
    }

    public GuestDto() {

    }

    public Long getMealId() {
        return mealId;
    }

    public void setMealId(Long mealId) {
        this.mealId = mealId;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }


    public GuestDto(Long id, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.partySize = "1";
    }

    public GuestDto(Long id, String firstName, String lastName,  String phoneNumber,
                    String address, String notes, Long mealId, Long statusId, String association, String email, String partySize) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.notes = notes;
        this.mealId = mealId;
        this.statusId = statusId;
        this.association = association;
        this.email = email;
        this.partySize = partySize;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


    public String getPartySize() {
        return partySize;
    }

    public void setPartySize(String partySize) {
        this.partySize = partySize;
    }


    @Override
    public String toString() {
        return "GuestDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", notes='" + notes + '\'' +
                ", mealId=" + mealId +
                ", statusId=" + statusId +
                ", association='" + association + '\'' +
                ", partySize='" + partySize + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
