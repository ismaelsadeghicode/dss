package com.dss.calculator.annotations;

import com.dss.calculator.functions.Addition;
import com.dss.calculator.functions.Division;
import com.dss.calculator.functions.Multiplication;
import com.dss.calculator.functions.Subtraction;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;




//This will be used once you want to make use of reflection ability




public class Reflection {
    public void reflection(){


        Class classReflector = Addition.class;
        Method[] methods = classReflector.getDeclaredMethods();
        for (Method method : methods) {
            Annotation annotation = method.getDeclaredAnnotation(Doc.class);
            Doc doc = (Doc)annotation;
            System.out.println("\t#Description: "+doc.description());
        }
        Class classReflector2 = Subtraction.class;
        Method[] methods2 = classReflector2.getDeclaredMethods();
        for (Method method2 : methods2) {
            Annotation annotation2 = method2.getDeclaredAnnotation(Doc.class);
            Doc doc2 = (Doc)annotation2;
            System.out.println("\t#Description: "+doc2.description());
        }
        Class classReflector3 = Multiplication.class;
        Method[] methods3 = classReflector3.getDeclaredMethods();
        for (Method method3 : methods3) {
            Annotation annotation3 = method3.getDeclaredAnnotation(Doc.class);
            Doc doc3 = (Doc)annotation3;
            System.out.println("\t#Description: "+doc3.description());
        }
        Class classReflector4 = Division.class;
        Method[] methods4 = classReflector4.getDeclaredMethods();
        for (Method method4 : methods4) {
            Annotation annotation4 = method4.getDeclaredAnnotation(Doc.class);
            Doc doc4 = (Doc)annotation4;
            System.out.println("\t#Description: "+doc4.description());
        }
    }
}
