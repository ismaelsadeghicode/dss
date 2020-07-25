package com.dss.database;

import java.util.HashMap;
import java.util.Stack;

public class UsersDatabase {

    private static HashMap <String,String> userInfo = new HashMap<>();

    public static String checkAndSignIn(String username, String password){
        if (userInfo.containsKey(username)==true){
            if(userInfo.get(username).equals(password)==true){
                return "Welcome!";
            }else{
                return "Wrong password!";
            }
        }else{
            return "User doesn't exist";
        }
    }

    public static boolean checkAndAddOne(String username, String password) {
        if(userInfo.containsKey(username)==true){
            return false;
        }else {
            userInfo.put(username, password);
            return true;
        }
    }

}
