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


    public GuestDto( Long id, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }


    //    @Column(nullable = false)
    private PlusOne plusOne;
    //    @Column(nullable = false)
    private MealChoice mealChoice;
    private Status status;

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

    public MealChoice getMealChoice() {
        return mealChoice;
    }

    public void setMealChoice(MealChoice mealChoice) {
        this.mealChoice = mealChoice;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlusOne getPlusOne() {
        return plusOne;
    }

    public void setPlusOne(PlusOne plusOne) {
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
