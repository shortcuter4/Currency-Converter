package com.shortcuter4.currencyconverter.repository;

import java.util.List;

import com.shortcuter4.currencyconverter.model.Currency;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepo extends CrudRepository<Currency, String> {
    @Override
    List<Currency> findAll();
}
