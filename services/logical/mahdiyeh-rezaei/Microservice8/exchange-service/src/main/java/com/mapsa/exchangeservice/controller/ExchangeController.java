package com.mapsa.exchangeservice.controller;

import com.mapsa.exchangeservice.client.ExchangeValueClient;
import com.mapsa.exchangeservice.domain.ExchangeValue;
import com.mapsa.exchangeservice.proxy.ExchangeValueProxy;
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

    //localhost:8100/exchange/from/btc/to/usd/quantity/10
    @GetMapping("from/{from}/to/{to}/quantity/{quantity}")
    public ExchangeValue getExchangeValue(@PathVariable String from,
                                          @PathVariable String to,
                                          @PathVariable int quantity) {
        ExchangeValue exchangeValue = exchangeValueProxy.EXCHANGE_VALUE(from, to);
        return new ExchangeValue()
                .setId(exchangeValue.getId())
                .setFrom(from)
                .setTo(to)
                .setQuantity(quantity)
                .setPort(exchangeValue.getPort())
                .setCurrencyMultiplier(exchangeValue.getCurrencyMultiplier())
                .setCurrencyConverter(quantity * exchangeValue.getCurrencyMultiplier());
    }
}
