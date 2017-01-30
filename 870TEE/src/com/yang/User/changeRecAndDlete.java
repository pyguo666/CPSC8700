package com.yang.User;

import com.opensymphony.xwork2.ActionSupport;
import com.yang.Dao.Preference;
import org.apache.struts2.interceptor.SessionAware;
import com.yang.Beans.Dish;

import java.util.Map;

/**
 * Created by GY on 12/3/2016.
 */
public class changeRecAndDlete extends ActionSupport implements SessionAware{
    public Map<String, Object> getSession() {
        return session;
    }
    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    private Map<String,Object>  session;


    public String execute(){
        String user = (String) session.get("username");
        Dish tmp = (Dish) session.get("recDish");
        int id = tmp.getDishID();
        Preference pre = new Preference(user,id);
        pre.create();
        return "success";
    }
}
