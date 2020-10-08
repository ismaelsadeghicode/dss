package com.mapsa.currencyservice.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

@Data
@Accessors(chain = true)
public class CurrencyValueDto {
    private Integer id;
    private String to;
    private String from;
    private int currencyMultiply;
    private int port;
}
