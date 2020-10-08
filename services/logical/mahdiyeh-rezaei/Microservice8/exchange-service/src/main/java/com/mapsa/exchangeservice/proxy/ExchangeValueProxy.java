package com.mapsa.exchangeservice.proxy;

import com.mapsa.exchangeservice.domain.ExchangeValue;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-service")
@RibbonClient
public interface ExchangeValueProxy {

    @GetMapping("currency/from/{from}/to/{to}")
    ExchangeValue EXCHANGE_VALUE(@PathVariable String from,@PathVariable String to);
}
