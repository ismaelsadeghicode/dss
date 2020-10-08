package com.mapsa.currencyservice.controller;

import com.mapsa.currencyservice.domain.CurrencyValue;
import com.mapsa.currencyservice.dto.CurrencyValueDto;
import com.mapsa.currencyservice.repository.CurrencyValueRepository;
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
    CurrencyValueRepository currencyValueRepository;

    @Autowired
    Environment environment;

    //localhost:8000/currency/from/btc/to/usd
    @GetMapping("/from/{from}/to/{to}")
    public CurrencyValueDto currencyValue(@PathVariable String from, @PathVariable String to) {

        CurrencyValue currencyValue = currencyValueRepository.findByFromContainingAndToContaining(from, to);
        if (currencyValue != null) {
            ModelMapper modelMapper = new ModelMapper();
            CurrencyValueDto currencyValueDto = modelMapper.map(currencyValue, CurrencyValueDto.class);
            currencyValueDto.setPort(Integer.parseInt(environment.getProperty("server.port")));
            return currencyValueDto;
        }
        return new CurrencyValueDto();
    }
}
