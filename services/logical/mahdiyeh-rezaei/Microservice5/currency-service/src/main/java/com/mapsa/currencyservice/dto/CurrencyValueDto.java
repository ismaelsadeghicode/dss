package com.mapsa.currencyservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class CurrencyValueDto {
    private Long id;
    private String from;
    private String to;
    private int currencyMultiply;
    private int port;
}
