package com.yang.Dao;

import com.yang.Beans.Dish;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Recommendation extends Connector {

    public ArrayList<Dish> PlaceRecomendation(String name){
        ArrayList<Dish> dList = new ArrayList<Dish>();
        String sql = "SELECT id,name,info FROM dish WHERE id NOT IN (SELECT id From preferrence WHERE preferrence.name = \'"+name+"\')";
        List<Map<String, Object>> list= connect(sql);
        for(int i=0;i<list.size();i++){
            Dish d = new Dish(new Integer(list.get(i).get("id").toString()),list.get(i).get("name").toString(),list.get(i).get("info").toString());
            dList.add(d);
        }
        return dList;
    }

    public static void main(String[] args) {
        Recommendation test = new Recommendation();
        ArrayList<Dish> rec = test.PlaceRecomendation("Yang");

        for(int i = 0; i <rec.size(); i++){
            System.out.println(i);
            System.out.println(rec.get(i).getDishName());
        }
    }
}

