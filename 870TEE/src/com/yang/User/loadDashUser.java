package com.yang.User;

import com.opensymphony.xwork2.ActionSupport;
import com.yang.*;
import com.yang.Beans.Dish;
import com.yang.Dao.Recommendation;
import org.apache.struts2.interceptor.SessionAware;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by GY on 12/3/2016.
 */
public class loadDashUser extends ActionSupport implements SessionAware {
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
        int max = prefList.size();

        int index = (int) (Math.random()*max);
        Dish recDish = prefList.get(index);

        session.put("recDish",recDish);

        index++;
        session.put("recNum",index);

        return "success";
    }

}
