package com.mapsa.dss.sales.service;


import com.mapsa.dss.sales.model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    List<Product> products = new ArrayList<Product>();
    public List<Product> getProducts(){
        Product product1 = new Product();
        product1.setId(1000);
        product1.setName("K571");
        product1.setBrand("Asus");
        product1.setCategory("Laptop");
        product1.setPrice(1117.60);

        Product product2 = new Product();
        product2.setId(1001);
        product2.setName("A50");
        product2.setBrand("Samsung");
        product2.setCategory("Mobile");
        product2.setPrice(239.99);

        products.add(product1);
        products.add(product2);

        return products;
    }
//
//    public void save(Product product){
//        Session session = HibernateConfig.getSession(product.getClass());
//        Transaction transaction = session.beginTransaction();
//        session.save(product);
//        transaction.commit();
//        session.close();
//    }
}
