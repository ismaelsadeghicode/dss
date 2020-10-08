package com.dss.exchangeservice.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ExchangeClient {


    public String getService(String from, String to,String quantity) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://blockchain.info/to" + to + "?currency="+from+"&value="+quantity;
        return restTemplate.getForObject(url,String.class);
    }
}
