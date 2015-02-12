package com.newmansoft.model;

/**
 * Created by andyn on 1/26/2015.
 */
public class PlusOne {

    String name;

    int mealChoiceId;
    long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PlusOne() {
    }

    public PlusOne(long id,String name, int mealChoiceId) {
        this.name = name;
        this.mealChoiceId = mealChoiceId;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMealChoiceId() {
        return mealChoiceId;
    }

    public void setMealChoiceId(int mealChoiceId) {
        this.mealChoiceId = mealChoiceId;
    }
}
