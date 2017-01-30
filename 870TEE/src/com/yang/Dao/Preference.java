package com.yang.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Preference extends Connector {
    public Preference(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public boolean check(){
        String sql = "SELECT name,id,FROM preferrence WHERE id = '" + this.id + "\'AND name=\'"+this.name+"\'";
        List<Map<String, Object>> list=connect(sql);
        if(list.size()>0){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean create() {
        String sql = "INSERT INTO preferrence VALUES (\'" + this.name + "\'," + this.id + ")";
        int i = update(sql);

        if (i != 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(){
        String sql = "DELETE  FROM preferrence  WHERE id = '"+this.id+"\' AND name=\'"+this.name+"\'";
        int i=update(sql);

        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }
    private String name;
    private int id;

    public static void main(String[] args) {
        Preference test = new Preference("Yang",11);

        System.out.println(test.create());
    }
}
