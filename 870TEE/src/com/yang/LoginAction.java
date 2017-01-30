package com.yang;
import java.sql.SQLException;
import java.util.*;

import  com.opensymphony.xwork2.ActionContext;
import  com.opensymphony.xwork2.ActionSupport;
import com.yang.Beans.UserBean;
import com.yang.Dao.User;

/**
 * Created by GY on 11/27/2016.
 */
public class LoginAction extends ActionSupport{
    private String username;
    private String password;

    public String execute() throws ClassNotFoundException, SQLException {
        if (this.username.equals("admin") && this.password.equals("admin")) {
            Map session = ActionContext.getContext().getSession();
            session.put("login", true);
            session.put("context", new Date());
            session.put("username", username);
            return "adminPage";
        } else {
            User  userDao = new User(username,password);
            if (userDao.check()) {
                Map session = ActionContext.getContext().getSession();
                UserBean userInfo = new UserBean();
                userInfo.testList(username, password);

                session.put("login", true);
                session.put("context", new Date());
                session.put("username",username);
                session.put("userInfo", userInfo);
                return "success";
            } else {
                addActionError(getText("error.login"));
                //a function from ActionSupport, to get properties values from properties file
                //we will explore this below.
                return "error";
            }
        }
    }
    public String logout(){
        Map session = ActionContext.getContext().getSession();
        session.remove("login");
        session.remove("context");
        session.remove("username");
        return "success";
    }

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





}

