package com.yang.User;

import java.sql.*;
import  com.opensymphony.xwork2.ActionContext;
import  com.opensymphony.xwork2.ActionSupport;
import com.yang.Dao.User;

/**
 * Created by GY on 11/30/2016.
 */
public class SignupAction extends ActionSupport
{
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String execute(){
        User newUser = new User(username,password);
        if(newUser.create()) return "success";
        else  return "error";
    }
}
