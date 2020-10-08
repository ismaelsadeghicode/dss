package com.mapsa.exchangeservice.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ExchangeValue implements Serializable {
    private Integer id;
    private String from;
    private String to;
    private int quantity;
    private int port;
    private int currencyMultiplier;
    private int currencyConverter;
}
