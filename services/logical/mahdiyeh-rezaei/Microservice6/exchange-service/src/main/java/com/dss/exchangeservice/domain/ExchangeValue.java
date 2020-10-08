package com.dss.exchangeservice.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ExchangeValue {
    private Integer id;
    private String from;
    private String to;
    private int currencyMultiply;
    private int port;
    private int quantity;
    private int currencyCalculation;
}
