package com.mapsa.service;

import com.mapsa.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ProductService {
    List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {

        Product p1=new Product();
        p1.setProductName("Ginger Anti-Dandruff Shampoo");
        p1.setProductDescription("Blended with ginger essential oil from Sri Lanka, birch bark, white willow extracts and Community Trade honey, our iconic anti-dandruff shampoo gently clears loose flakes and soothes the scalp. Follow up with Ginger Scalp Care Conditioner for optimum results.");
        p1.setProductPic("1.png");

        Product p2=new Product();
        p2.setProductName("Hemp Hand Protector");
        p2.setProductDescription("Our best-selling Hemp Hand Protector helps soften and protect hands. It is dermatologically tested for very dry skin and contains hemp seed oil.");
        p2.setProductPic("2.png");

        Product p3=new Product();
        p3.setProductName("Coconut Hand Cleanse Gel");
        p3.setProductDescription("Help keep your hands freshly-scented and clean with our Coconut Hand Cleanse Gel. In a tropical coconut scent, this hand cleanse gel is perfect for popping in your bag for rinse-free cleansing, to help keep your hands clean when you’re on-the-go.");
        p3.setProductPic("3.png");

        products.add(p1);
        products.add(p2);
        products.add(p3);

        return products;
    }
}
