package com.mapsa.model;

import com.mapsa.persistance.Column;
import com.mapsa.persistance.Entity;
import com.mapsa.persistance.Table;

@Entity
@Table(name = "category")
public class Category {

    @Column(name = "category_name",dataType = "VARCHAR",length = 50)
    private String  name;
    @Column(name = "category_parent",dataType = "VARCHAR",length = 50)
    private String category_parent;

    public Category() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory_parent() {
        return category_parent;
    }

    public void setCategory_parent(String category_parent) {
        this.category_parent = category_parent;
    }
}
