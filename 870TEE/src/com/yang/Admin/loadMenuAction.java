package com.yang.Admin;

/**
 * Created by GY on 12/1/2016.
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import com.yang.*;

import com.yang.Beans.Dish;
import com.yang.Dao.DishDao;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class loadMenuAction extends ActionSupport implements SessionAware {

    public Map<String, Object> getSession() {
        return session;
    }
    @Override
    public void setSession(Map<String, Object> map) {

    }

    private Map<String,Object>  session;

    public ArrayList<Dish> getDishMenu() {
        return dishMenu;
    }

    public void setDishMenu(ArrayList<Dish> dishMenu) {
        this.dishMenu = dishMenu;
    }

    private ArrayList<Dish> dishMenu;

    public String execute(){
        DishDao allDish = new DishDao();
        dishMenu = allDish.AllDishs();
        return "success";
    }


}