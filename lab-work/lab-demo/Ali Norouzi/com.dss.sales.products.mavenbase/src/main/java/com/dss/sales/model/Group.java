package com.dss.sales.model;

import org.springframework.stereotype.Component;

@Component
public class Group {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParrentid() {
        return parrentid;
    }

    public void setParrentid(String parrentid) {
        this.parrentid = parrentid;
    }

    private String name;
    private String parrentid;
    public Group(){}
}
