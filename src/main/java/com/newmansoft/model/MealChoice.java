package com.newmansoft.model;

/**
 * Created by andyn on 1/26/2015.
 */
public class MealChoice {

    private Long id;
    private String name;


    public MealChoice() {
    }

    public MealChoice(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
