package com.mapsa.exchangeservice.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.io.Serializable;
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ExchangeValue implements Serializable {
    private Long id;
    private String from;
    private String to;
    private int currencyMultiply;
    private int port;
    private int quantity;
    private int currencyCalculation;
}
