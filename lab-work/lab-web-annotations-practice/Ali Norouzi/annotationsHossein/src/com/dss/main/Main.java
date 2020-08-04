package com.dss.main;

import com.dss.config.Configuration1;
import com.dss.data.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    @Autowired
    Data data;
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Configuration1.class);
        Data human = (Data) context.getBean(Data.class);
        human.getData();
    }
}

