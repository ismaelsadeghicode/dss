package com.mapsa.exchangeservice.client;

import com.mapsa.exchangeservice.domain.ExchangeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
public class CurrencyServiceClient {
    @Autowired
    private RestTemplate restTemplate;

    @Bean
    protected RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public ExchangeValue getCurrency(String from, String to) {

        String url = "http://localhost:8000/currency/from/" + from + "/to/" + to;
        ExchangeValue exchangeValue = restTemplate.getForObject(url, ExchangeValue.class);
        return exchangeValue;
    }
}
