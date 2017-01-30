package com.yang.Admin;

import com.opensymphony.xwork2.ActionSupport;
import com.yang.*;
import com.yang.Dao.DishDao;

import java.util.ArrayList;

/**
 * Created by GY on 11/30/2016.
 */
public class AdminAdd extends ActionSupport{
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

    private int dishID;

    public int getDishID() {
        return dishID;
    }

    public void setDishID(int dishID) {
        this.dishID = dishID;
    }
    private String dishName;
    private String dishURL;
    public String execute(){
        DishDao newDish = new DishDao(dishID,dishName,dishURL);
        if(newDish.create()) return "success";
        else return "error";
    }
}
