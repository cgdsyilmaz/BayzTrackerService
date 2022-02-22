package com.cagdasyilmaz.bayztracker.currency.service;

import com.cagdasyilmaz.bayztracker.currency.repository.CurrencyRepository;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    private final CurrencyRepository currencyRepository;

    public CurrencyServiceImpl(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }


}
