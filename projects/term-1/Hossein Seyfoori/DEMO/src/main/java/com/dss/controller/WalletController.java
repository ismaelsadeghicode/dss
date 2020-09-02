package com.dss.controller;


import com.dss.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/wallet")
public class WalletController  {


    @Autowired
    WalletService walletService;

    @RequestMapping
    public ModelAndView show(HttpSession session){


        if(session.getAttribute("user_id") == null)
        {
            return new ModelAndView("login","message","لطفا لاگین کنید");
        }
        int user_id = (int) session.getAttribute("user_id");




        ModelAndView mv = new ModelAndView("wallet");
        mv.addObject("wallets",walletService.allWallets());


        return mv;

    }
    @RequestMapping("/create")
    public ModelAndView create(@RequestParam("name") String name,HttpSession session)
    {


        ModelAndView modelAndView = walletService.create(name,session);
        modelAndView.addObject("wallets",walletService.allWallets());


        return modelAndView;

    }
    @RequestMapping("/delete")
    public String delelte(@RequestParam int id)
    {
        return walletService.delete(id);
    }

}
