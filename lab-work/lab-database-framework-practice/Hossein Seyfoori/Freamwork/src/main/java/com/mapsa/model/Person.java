package com.mapsa.model;

import com.mapsa.persistance.Column;
import com.mapsa.persistance.Entity;
import com.mapsa.persistance.Table;
import jdk.jfr.internal.Cutoff;

@Entity
@Table(name = "person")
public class Person {

    @Column(name = "name",dataType = "VARCHAR",length = 10)
    private String name;
    @Column(name = "phone",dataType = "VARCHAR",length = 10)
    private String phone;


    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
