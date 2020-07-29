package com.dss;


public class Main {

    public static void main(String[] args) throws NoSuchMethodException {
        UserController userController = new UserController(Access.Level.GUST);
        userController.setName("hossein"); // ACCESS -> ADMIN
        userController.setPhone("09389337979"); // ACCESS ->GUEST
        System.out.println(userController.getName());
        System.out.println(userController.getPhone());

    }
}
