package com.dss.calculator.main;

import com.dss.calculator.functions.Addition;
import com.dss.calculator.functions.Division;
import com.dss.calculator.functions.Multiplication;
import com.dss.calculator.functions.Subtraction;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\t ====> Calculator <==== \n Welcome! \n Choose your desired function");
        System.out.println("1)Addition 2)Subtraction 3)Multiplication 4)Division ");
        int input = sc.nextInt();
        System.out.println("Enter your first and second numbers:");
        double first = sc.nextDouble();
        double second = sc.nextDouble();
        switch (input){
            case 1:
                Addition.addition((int)first,(int)second);
                break;
            case 2:
                Subtraction.subtraction((int)first,(int)second);
                break;
            case 3:
                Multiplication.multiplication((int)first,(int)second);
                break;
            case 4:
                Division.division(first,second);
                break;
            default:
                break;
        }
    }
}
