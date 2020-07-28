package com.dss.calculator.functions;

import com.dss.calculator.annotations.Doc;

public class Subtraction {
    @Doc(
            description = "This will perform subtraction on two given integer numbers"
    )
    public static int subtraction(int a, int b){
        int result = b-a;
        System.out.println("your subtraction result is: "+result);
        return result;
    }
}
