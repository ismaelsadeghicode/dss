package com.dss.calculator.functions;

import com.dss.calculator.annotations.Doc;

public class Addition {
    @Doc(
            description = "This will perform addition on two given integer numbers"
    )
    public static int addition(int a, int b){
        int result = a+b;
        System.out.println("your addition result is: "+result);
        return result;
    }
}
