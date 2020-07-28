package com.dss.calculator.functions;

import com.dss.calculator.annotations.Doc;

public class Division {
    @Doc(
            description = "This will perform division on two given integer numbers"
    )
    public static double division(double a, double b){
        double result = a/b;
        System.out.println("your division result is: "+result);
        return result;
    }
}
