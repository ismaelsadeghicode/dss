package com.dss.sales.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
@Service
public class UsersDatabase {

    private static HashMap <String,String> userInfo = new HashMap<>();

    public static String checkAndSignIn(String username, String password){
        if (userInfo.containsKey(username)){
            if(userInfo.get(username).equals(password)){
                return "Welcome!";
            }else{
                return "Wrong password!";
            }
        }else{
            return "User doesn't exist";
        }
    }

    public static boolean checkAndAddOne(String username, String password) {
        if(userInfo.containsKey(username)){
            return false;
        }else {
            userInfo.put(username, password);
            return true;
        }
    }

}
