package com.yang.User;

import com.opensymphony.xwork2.ActionSupport;
import com.yang.Dao.Preference;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * Created by GY on 11/30/2016.
 */
public class userDelete extends ActionSupport implements SessionAware{
    public Map<String, Object> getSession() {
        return session;
    }
    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    private Map<String,Object>  session;

    private int dishID;
    private String dishName;

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

    public String execute(){
        String user = (String) session.get("username");
        Preference pre = new Preference(user,dishID);
        if(pre.create()) return "success";
        else return "error";
}
}
