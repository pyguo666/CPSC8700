package com.yang.Dao;

import java.util.List;
import java.util.Map;

/**
 * Created by fpei on 2016/11/27.
 */
public class User extends Connector {
    public User(String name,String Password) {
        setName(name);
        setPassword(Password);
    }
    public boolean check() {
        String sql = "SELECT name,password FROM user WHERE name = \'"+this.name+"\'AND password=\'"+this.password+"\'";
        List<Map<String, Object>> list=connect(sql);
        if(list.size()>0){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean create(){
        String sql = "INSERT INTO user VALUES (\'"+this.name+"\',\'"+this.password+"\')";
        int i= update(sql);

        System.out.println(i);

        if(i!=0){
            return true;
        }
        else{
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    private String name;
    private String password;

    public static void main(String[] args){
        User test = new User("flower","flower");
        System.out.print(test.create());
    }

}
