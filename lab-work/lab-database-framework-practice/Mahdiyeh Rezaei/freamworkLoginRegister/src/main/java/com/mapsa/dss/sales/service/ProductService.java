package com.mapsa.dss.sales.service;

import com.mapsa.dss.sales.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        Product p1 = new Product();
        p1.setName("ACER");
        p1.setPrice("1200$");
        p1.setCategory("Laptop");

        Product p2 = new Product();
        p2.setName("Samsung");
        p2.setPrice("1300$");
        p2.setCategory("Laptop");

        Product p3 = new Product();
        p3.setName("Asus");
        p3.setPrice("1400$");
        p3.setCategory("Laptop");


        products.add(p1);
        products.add(p2);
        products.add(p3);

        return products;
    }
}
