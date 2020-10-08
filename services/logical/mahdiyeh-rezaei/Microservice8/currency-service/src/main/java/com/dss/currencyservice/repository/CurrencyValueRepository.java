package com.dss.currencyservice.repository;

import com.dss.currencyservice.domain.CurrencyValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyValueRepository extends JpaRepository<CurrencyValue,Integer> {
    CurrencyValue findByFromContainingAndToContaining(String from,String to);
}
