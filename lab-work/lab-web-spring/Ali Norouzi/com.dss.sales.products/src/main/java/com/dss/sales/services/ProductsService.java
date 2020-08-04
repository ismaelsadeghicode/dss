package com.dss.sales.services;

import com.dss.sales.model.Group;
import com.dss.sales.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductsService {
    @Autowired
    private List<Products> products = new ArrayList<>();

    public List<Products> ProductsService(){
        Group gp1 = new Group();
        gp1.setName("Gpus");
        gp1.setParrentid("0");

        Group gp2 = new Group();
        gp2.setName("Nvidia");
        gp2.setParrentid(gp1.getName());

        Group gp3 = new Group();
        gp3.setName("AMD");
        gp3.setParrentid(gp1.getName());

        Group gp4 = new Group();
        gp4.setName("Intel");
        gp4.setParrentid(gp1.getName());

        Products product1 = new Products();
        product1.setName("RTX 2080TI");
        product1.setGroup(gp2);
        product1.setPrice(18000000);
        product1.setDescription("Best suitable for gaming setups and heavy workloads");

        Products product2 = new Products();
        product2.setName("Radeon 5700 XT");
        product2.setGroup(gp3);
        product2.setPrice(14000000);
        product2.setDescription("Best suitable for gaming setups and heavy workloads");

        Products product3 = new Products();
        product3.setName("Xe Graphics");
        product3.setGroup(gp4);
        product3.setPrice(0);
        product3.setDescription("Not released yet!");

        products.add(product1);
        products.add(product2);
        products.add(product3);

        return products;
    }
}
