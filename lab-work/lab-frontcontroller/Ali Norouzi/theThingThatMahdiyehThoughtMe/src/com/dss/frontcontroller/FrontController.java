package com.dss.frontcontroller;

public class FrontController {
    private Dispatcher dispatcher;

    public FrontController(){
        dispatcher = new Dispatcher();
    }

    public static boolean Authorisation(String req){
        if(req.equalsIgnoreCase("user")
                || req.equalsIgnoreCase("admin")
                || req.equalsIgnoreCase("home")){
            System.out.println("Authorised");
            return true;
        }else{
            return false;
        }
    }

    public static String logger(String req){
        System.out.println(req + "logged");
        return req + "logged";
    }

    public void dispatchRequest(String req){
        FrontController.logger(req);
        if(FrontController.Authorisation(req)){
            dispatcher.dispatcher(req);
        }else{
            System.err.println("Err!");
        }
    }
}
