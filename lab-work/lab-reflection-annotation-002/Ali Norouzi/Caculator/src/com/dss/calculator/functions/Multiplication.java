package com.dss.calculator.functions;

import com.dss.calculator.annotations.Doc;

public class Multiplication {
    @Doc(
            description = "This will perform multiplication on two given integer numbers"
    )
    public static int multiplication(int a, int b){
        int result = b*a;
        System.out.println("your multiplication result is: "+result);
        return result;
    }

}
