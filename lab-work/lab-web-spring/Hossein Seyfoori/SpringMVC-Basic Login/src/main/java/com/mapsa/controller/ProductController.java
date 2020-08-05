package com.mapsa.controller;

import com.mapsa.model.Product;
import com.mapsa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {


    @Autowired
    ProductService productService ;

    @GetMapping("/product")
    public ModelAndView product()
    {
        ModelAndView mv = new ModelAndView();

        List<Product> products = productService.getProducts();

        mv.setViewName("product");
        mv.addObject("products",products);


        return mv;
    }

}
