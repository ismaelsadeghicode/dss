package com.dss.main;

import com.dss.frontcontroller.FrontController;

public class Main {
    public static void main(String[] args) {
        FrontController frontController = new FrontController();
        frontController.dispatchRequest("Admin");
        frontController.dispatchRequest("User");
        frontController.dispatchRequest("Home");
        frontController.dispatchRequest("Mahdiyeh");
    }
}
