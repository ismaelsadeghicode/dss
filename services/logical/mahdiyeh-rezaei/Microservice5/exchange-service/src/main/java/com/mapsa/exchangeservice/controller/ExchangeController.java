package com.mapsa.exchangeservice.controller;

import com.mapsa.exchangeservice.client.CurrencyServiceClient;
import com.mapsa.exchangeservice.domain.ExchangeValue;
import com.mapsa.exchangeservice.proxy.CurrencyServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("exchange")
public class ExchangeController {

    @Autowired
    CurrencyServiceClient client;

    @Autowired
    CurrencyServiceProxy serviceProxy;

    //localhost:8100/exchange/from/btc/to/usd/quantity/10
    @GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
    public ExchangeValue getExchangeValue(@PathVariable String from,
                                          @PathVariable String to,
                                          @PathVariable int quantity){
        //ExchangeValue currency = client.getCurrency(from, to);
        ExchangeValue currency = serviceProxy.getCurrency(from, to);
        return new ExchangeValue()
                .setId(currency.getId())
                .setFrom(from)
                .setTo(to)
                .setQuantity(quantity)
                .setPort(currency.getPort())
                .setCurrencyMultiply(currency.getCurrencyMultiply())
                .setCurrencyCalculation(currency.getCurrencyMultiply() * quantity);
    }
}
