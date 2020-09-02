package com.dss.sales.services;

import java.util.HashMap;

@Deprecated
public class UsersDatabase {
    @Deprecated
    private static HashMap <String,String> userInfo = new HashMap();
    @Deprecated
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
    @Deprecated
    public static boolean checkAndAddOne(String username, String password) {
        if(userInfo.containsKey(username)){
            return false;
        }else {
            userInfo.put(username, password);
            return true;
        }
    }

}
