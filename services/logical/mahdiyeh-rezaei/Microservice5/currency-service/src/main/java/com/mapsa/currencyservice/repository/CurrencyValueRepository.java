package com.mapsa.currencyservice.repository;

import com.mapsa.currencyservice.domain.CurrencyValue;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CurrencyValueRepository extends JpaRepository<CurrencyValue, Long> {
    CurrencyValue findByFromContainingAndToContaining(String from, String to);
}
