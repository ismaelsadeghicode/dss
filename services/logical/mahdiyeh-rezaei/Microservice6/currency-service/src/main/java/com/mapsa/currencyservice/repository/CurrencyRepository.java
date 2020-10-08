package com.mapsa.currencyservice.repository;

import com.mapsa.currencyservice.domain.CurrencyValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<CurrencyValue,Integer> {
    CurrencyValue findByFromContainingAndToContaining(String from,String to);
}
