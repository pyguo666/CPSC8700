package com.yang.Admin;

/**
 * Created by GY on 11/30/2016.
 */

import com.opensymphony.xwork2.ActionSupport;
import com.yang.Dao.DishDao;

/**
 * Created by GY on 11/30/2016.
 */
public class AdminUpdate extends ActionSupport {
    private String dishName;
    private int dishID;
    private String dishURL;

    public String getDishURL() {
        return dishURL;
    }

    public void setDishURL(String dishURL) {
        this.dishURL = dishURL;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public int getDishID() {
        return dishID;
    }

    public void setDishID(int dishID) {
        this.dishID = dishID;
    }

    public String execute(){
        DishDao newDish = new DishDao(dishID,dishName,dishURL);
        if(newDish.update()) return "success";
        else return "error";
    }
}