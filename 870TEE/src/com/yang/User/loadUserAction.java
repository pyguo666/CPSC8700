package com.yang.User;

/**
 * Created by GY on 12/1/2016.
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import com.yang.*;

import com.yang.Beans.Dish;
import com.yang.Dao.Recommendation;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class loadUserAction extends ActionSupport implements SessionAware {

    public Map<String, Object> getSession() {
        return session;
    }
    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    private Map<String,Object>  session;

    public ArrayList<Dish> getPrefList() {
        return prefList;
    }

    public void setPrefList(ArrayList<Dish> prefList) {
        this.prefList = prefList;
    }

    private ArrayList<Dish> prefList;


    public String execute(){
        Recommendation rec = new Recommendation();
        String user = (String) session.get("username");
        prefList = rec.PlaceRecomendation(user);
        return "success";
    }

}