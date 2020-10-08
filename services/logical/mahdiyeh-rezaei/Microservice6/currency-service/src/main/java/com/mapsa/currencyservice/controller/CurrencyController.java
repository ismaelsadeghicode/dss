package com.mapsa.currencyservice.controller;

import com.mapsa.currencyservice.domain.CurrencyValue;
import com.mapsa.currencyservice.dto.CurrencyValueDto;
import com.mapsa.currencyservice.repository.CurrencyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("currency")
public class CurrencyController {
    @Autowired
    CurrencyRepository currencyRepository;

    @Autowired
    Environment environment;

    @GetMapping("from/{from}/to/{to}")
    public CurrencyValueDto getCurrency(@PathVariable String from, @PathVariable String to){
        CurrencyValue currencyValue = currencyRepository.findByFromContainingAndToContaining(from, to);
        if (currencyValue != null){
            ModelMapper mapper = new ModelMapper();
            CurrencyValueDto currencyValueDto = mapper.map(currencyValue, CurrencyValueDto.class);
            currencyValueDto.setPort(Integer.parseInt(environment.getProperty("server.port")));
            return currencyValueDto;
        }
        return new CurrencyValueDto();
    }
}
