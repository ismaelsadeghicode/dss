package com.mapsa.exchangeservice.client;

import com.mapsa.exchangeservice.domain.ExchangeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Component
public class ExchangeValueClient {
    @Autowired
    RestTemplate restTemplate;

    public ExchangeValue getCurrency(String from,String to){
        String url= "http://rezaei:8000/currency/from/"+from+"/to/"+to;
        ExchangeValue object = restTemplate.getForObject(url, ExchangeValue.class);
        return object;
    }
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
