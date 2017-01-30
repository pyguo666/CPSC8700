package com.yang.Dao;
import com.yang.Beans.Dish;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DishDao extends Connector {
    public DishDao(int id, String name, String info) {
        setId(id);
        setInfo(info);
        setName(name);
    }

    public DishDao(String name, String info) {
        this.name = name;
        this.info = info;
    }

    public DishDao(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public DishDao(){

    }
    public ArrayList<Dish> AllDishs(){
        ArrayList<Dish> dList = new ArrayList<Dish>();
        String sql = "SELECT dish.id, dish.name, dish.info FROM dish";
        List<Map<String, Object>> list=connect(sql);
        for(int i=0;i<list.size();i++){
            Dish d = new Dish(new Integer(list.get(i).get("id").toString()),list.get(i).get("name").toString(),list.get(i).get("info").toString());
            dList.add(d);
        }
        return dList;
    }
    public boolean check(){
        String sql = "SELECT id,name,info FROM dish WHERE id = '" + this.id + "\'AND name=\'"+this.name+"\'";
        List<Map<String, Object>> list=connect(sql);
        if(list.size()>0){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean create(){
        String sql = "INSERT INTO dish VALUES ("+this.id+",\'"+this.name+"\',\'" + this.info + "\')";
        int i=update(sql);

        if(i!=0&&check()){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean delete(){
        String sql = "DELETE FROM dish  WHERE id = '"+this.id+"\'AND name=\'"+this.name+"\'";
        int i=update(sql);

        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean update(){
        String sql = "UPDATE dish SET id ="+ this.id+", name=\'"+this.name+"\', info=\'"+this.info+"\' WHERE id =" + this.id ;
        int i=update(sql);

        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    private int id;
    private String name;
    private String info;

    public static void main(String[] args) {
        DishDao test = new DishDao(101,"test2","test.com");
        System.out.println(test.create());

//        DishDao test = new DishDao(101,"test2");
//        System.out.println(test.delete());

//        DishDao test = new DishDao(0,"test2");
//
//        System.out.println(test.delete());
//        DishDao test = new DishDao();
//        ArrayList<Dish> rec = test.AllDishs();
//
//        for(int i = 0; i <rec.size(); i++){
//            System.out.print("gaga");
//            System.out.println(rec.get(i).getDishName());
//            System.out.print("gaga");
//        }

    }
}
