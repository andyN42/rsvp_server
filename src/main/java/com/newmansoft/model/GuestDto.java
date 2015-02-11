package com.newmansoft.model;


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

    private String email;

    private PlusOne plusOneInfo;

    public PlusOne getPlusOneInfo() {
        return plusOneInfo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPlusOneInfo(PlusOne plusOneInfo) {
        this.plusOneInfo = plusOneInfo;
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


    public GuestDto( Long id, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public GuestDto(Long id, String firstName, String lastName,  String phoneNumber,
                    String address, String notes, Long mealId, Long statusId, String association) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.notes = notes;
        this.mealId = mealId;
        this.statusId = statusId;
        this.association = association;
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
}
