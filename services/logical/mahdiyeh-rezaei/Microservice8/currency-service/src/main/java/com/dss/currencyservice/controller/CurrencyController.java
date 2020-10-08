package com.dss.currencyservice.controller;

import com.dss.currencyservice.domain.CurrencyValue;
import com.dss.currencyservice.dto.CurrencyValueDto;
import com.dss.currencyservice.repository.CurrencyValueRepository;
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
    private CurrencyValueDto currencyValueDto;

    @Autowired
    CurrencyValueRepository currencyValueRepository;

    @Autowired
    Environment environment;

    //localhost:8000/currency/from/btc/to/usd
    @GetMapping("from/{from}/to/{to}")
    public CurrencyValueDto getCurrencyValue(@PathVariable String from,
                                             @PathVariable String to) {
        CurrencyValue repository = currencyValueRepository.findByFromContainingAndToContaining(from, to);
        ModelMapper modelMapper = new ModelMapper();
        currencyValueDto = modelMapper.map(repository, CurrencyValueDto.class);
        currencyValueDto.setPort(Integer.parseInt(environment.getProperty("server.port")));
        currencyValueDto.setCurrencyMultiplier(repository.getCurrencyMultiplier());
        return currencyValueDto;
    }
}
