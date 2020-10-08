package com.dss.exchangeservice.proxy;

import com.dss.exchangeservice.domain.ExchangeValue;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-server")
@RibbonClient
public interface ExchangeValueProxy {
    @GetMapping("currency/from/{from}/to/{to}")
    ExchangeValue getCurrency(@PathVariable String from, @PathVariable String to);
}
