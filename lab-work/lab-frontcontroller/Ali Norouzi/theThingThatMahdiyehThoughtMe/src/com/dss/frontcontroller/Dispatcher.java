package com.dss.frontcontroller;

import com.dss.pages.Admin;
import com.dss.pages.Home;
import com.dss.pages.User;

public class Dispatcher {
    private Admin admin;
    private User user;
    private Home home;
    public Dispatcher(){
        admin = new Admin();
        user = new User();
        home = new Home();
    }
    public void dispatcher(String req){
        if(req.equalsIgnoreCase("user")){
            user.showUser();
        }else if(req.equalsIgnoreCase("home")){
            home.showHome();
        }else if(req.equalsIgnoreCase("admin")){
            admin.showAdmin();
        }else{
            System.err.println("ERROR!");
        }
    }
}
