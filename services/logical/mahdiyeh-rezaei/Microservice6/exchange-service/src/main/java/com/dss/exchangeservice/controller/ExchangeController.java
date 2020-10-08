package com.dss.exchangeservice.controller;

import com.dss.exchangeservice.client.ExchangeClient;
import com.dss.exchangeservice.domain.ExchangeValue;
import com.dss.exchangeservice.proxy.ExchangeValueProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("exchange")
public class ExchangeController {

    @Autowired
    ExchangeValueProxy exchangeValueProxy;

    @GetMapping("from/{from}/to/{to}/quantity/{quantity}")
    public ExchangeValue getExchangeValue(@PathVariable String from,
                                          @PathVariable String to,
                                          @PathVariable String quantity) {
//        ExchangeValue currency = exchangeValueProxy.getCurrency(from, to);
        ExchangeClient client = new ExchangeClient();
        String service = client.getService(from, to, quantity);
        ExchangeValue currency = new ExchangeValue();

        currency.setQuantity(Integer.parseInt(quantity));
        currency.setCurrencyCalculation(Integer.parseInt(quantity) * Integer.parseInt(service));
        return currency;
    }
}
