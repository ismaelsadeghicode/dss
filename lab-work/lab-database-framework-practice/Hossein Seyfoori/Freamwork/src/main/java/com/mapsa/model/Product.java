package com.mapsa.model;

import com.mapsa.persistance.Column;
import com.mapsa.persistance.Entity;
import com.mapsa.persistance.Table;

@Entity
@Table(name = "product")
public class Product {

    @Column(name ="product_name",dataType = "VARCHAR",length = 50)
    String name;
    @Column(name ="product_size",dataType = "VARCHAR",length = 50)
    String size;

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
