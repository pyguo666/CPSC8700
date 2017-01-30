package com.yang.Admin;

import com.opensymphony.xwork2.ActionSupport;
import com.yang.Dao.DishDao;

/**
 * Created by GY on 11/30/2016.
 */
public class AdminDelete extends ActionSupport {
    private String dishName;
    private int dishID;

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
        DishDao newDish = new DishDao(dishID,dishName);
        if(newDish.delete()) return "success";
        else return "error";
    }
}
