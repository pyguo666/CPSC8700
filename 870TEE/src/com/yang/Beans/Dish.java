package com.yang.Beans;

/**
 * Created by GY on 12/1/2016.
 */
public class Dish {
    public Dish(int dishID, String dishName, String dishURL) {
        this.dishID = dishID;
        this.dishName = dishName;
        this.dishURL = dishURL;
    }

    public Dish() {
    }

    private int dishID;
    private String dishName;
    private String dishURL;

    public int getDishID() {
        return dishID;
    }

    public void setDishID(int dishID) {
        this.dishID = dishID;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishURL() {
        return dishURL;
    }

    public void setDishURL(String dishURL) {
        this.dishURL = dishURL;
    }


}
