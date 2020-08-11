package com.dss.database.practice.model;

import com.dss.database.practice.annotations.Column;
import com.dss.database.practice.annotations.Entity;
import com.dss.database.practice.annotations.Table;

@Entity
@Table(name = "PRODUCTS")
public class Product {
    @Column(name = "NAME", dataType = "VARCHAR",length = 20)
    private String name;
    @Column(name = "PRICE",dataType = "NUMBER",length = 10)
    private int price;
}
