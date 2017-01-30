package com.yang;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * Created by GY on 11/28/2016.
 */
public class LogoutAction extends ActionSupport {

    public String execute(){
        Map session = ActionContext.getContext().getSession();
        session.remove("login");
        session.remove("context");
        session.remove("username");
        return "success";
    }

}
