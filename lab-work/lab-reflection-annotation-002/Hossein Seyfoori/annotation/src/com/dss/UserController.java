package com.dss;


import com.dss.Access.Level;

import java.lang.reflect.Method;


public class UserController {


    private String name;

    private String lastName;

    private String phone;

    private Level level;

    public UserController(Level level) {
        this.level = level;
    }

    public String getName() {
        if (name == null) {
            return "empty";
        }
        return this.name;
    }

    @Access(level = Level.ADMIN)
    public void setName(String name) throws NoSuchMethodException {
        if (checkPermission() == Level.ADMIN) {
            this.name = name;
        } else {
            System.out.println("ACCESS DENIED");
        }
    }

    public String getPhone() {
        if (phone == null) {
            return "empty";
        }
        return this.phone;
    }

    @Access(level = Level.GUST)
    public void setPhone(String phone) {
        if (checkPermission() == Level.GUST) {
            this.phone = phone;
        } else {
            System.out.println("ACCESS DENIED");
        }
    }

    private Level checkPermission() {

        Method[] declaredMethods = this.getClass().getDeclaredMethods();
        Level level = null;
        for (Method declaredMethod : declaredMethods) {
            Access annotation = declaredMethod.getAnnotation(Access.class);
            if (declaredMethod.isAnnotationPresent(Access.class)) {
                if (this.level == Level.ADMIN && annotation.level() == level.ADMIN) {
                    level = Level.ADMIN;
                } else {
                    level = level.GUST;
                }

            }

        }
        return level;

    }
}
