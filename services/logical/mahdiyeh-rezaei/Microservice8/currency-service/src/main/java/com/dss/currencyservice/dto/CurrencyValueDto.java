package com.dss.currencyservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Component
public class CurrencyValueDto {
    private Integer id;
    private String from;
    private String to;
    private int currencyMultiplier;
    private int port;
}
