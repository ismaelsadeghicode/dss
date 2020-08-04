package com.dss.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Data {
    @Autowired
    private Human humanOne;

    public void getData(){
        System.out.println("{ " +humanOne.name+ ","+humanOne.nationality+","+humanOne.age+" }");
    }

}
