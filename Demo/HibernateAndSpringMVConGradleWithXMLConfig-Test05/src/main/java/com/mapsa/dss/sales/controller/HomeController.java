package com.mapsa.dss.sales.controller;

import com.mapsa.dss.sales.dao.PersonDao;
import com.mapsa.dss.sales.dao.ProductDAO;
import com.mapsa.dss.sales.model.Product;
import com.mapsa.dss.sales.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    ProductService productService;
    @Autowired
    private PersonDao personDao;
    @Autowired
    private ProductDAO productDAO;

    @RequestMapping("/")
    public ModelAndView home(){
//        productDAO.findAllProducts();
//        return "index";
        List<Product> products = productService.getProducts();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("products", products);
        return modelAndView;
    }
    @RequestMapping("/product")
    public ModelAndView getProduct(){
        List<Product> products = productDAO.findAllProducts();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("products",products);
        return modelAndView;
    }
    @RequestMapping("/save")
    public String save(){
        Product product = new Product();
//        product.setId(200);
        product.setName("A70");
        product.setBrand("Samsung");
        product.setPrice(117.02);
        product.setCategory("Mobile");

//        productService.save(product);

        return "index";
    }
}
