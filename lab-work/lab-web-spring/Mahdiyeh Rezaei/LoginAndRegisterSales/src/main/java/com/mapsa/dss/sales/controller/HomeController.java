package com.mapsa.dss.sales.controller;

import com.mapsa.dss.sales.model.Product;
import com.mapsa.dss.sales.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProductService productService;

    @RequestMapping("/")
    public ModelAndView home(){
        List<Product> products = productService.getProducts();

        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        mv.addObject("products",products);
        return mv;
    }
}
