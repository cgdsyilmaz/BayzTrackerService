package com.cagdasyilmaz.bayztracker.currency.service;

import com.cagdasyilmaz.bayztracker.currency.entity.Currency;
import com.cagdasyilmaz.bayztracker.currency.exception.CurrencyAlreadyExistsException;
import com.cagdasyilmaz.bayztracker.currency.exception.InvalidCurrencyPriceException;
import com.cagdasyilmaz.bayztracker.currency.exception.NoSuchCurrencyException;
import com.cagdasyilmaz.bayztracker.currency.exception.UnsupportedCurrencyCreationException;
import com.cagdasyilmaz.bayztracker.currency.repository.CurrencyRepository;
import com.cagdasyilmaz.bayztracker.currency.util.CurrencyUtil;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    private final CurrencyRepository currencyRepository;

    public CurrencyServiceImpl(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }


    @Override
    public List<Currency> getAllCurrencies() {
        return currencyRepository.findAll();
    }

    @Override
    public Currency getCurrency(String symbol) {
        return currencyRepository.findCurrencyBySymbol(symbol).orElseThrow(() -> new NoSuchCurrencyException(
            symbol));
    }

    @Override
    public Currency getCurrency(UUID currencyId) {
        return currencyRepository.findCurrencyByCurrencyId(currencyId).orElseThrow(() -> new NoSuchCurrencyException(
            currencyId.toString()));
    }

    @Override
    @Transactional
    public UUID addCurrency(Currency currency) {
        convertSymbolToAllCaps(currency);
        validateCurrency(currency);
        setCurrencyIdAndDate(currency);

        currencyRepository.save(currency);
        return currency.getCurrencyId();
    }

    private void convertSymbolToAllCaps(Currency currency) {
        currency.setSymbol(currency.getSymbol().toUpperCase());
    }

    private void validateCurrency(Currency currency) {
        String symbol = currency.getSymbol();
        validateCurrencySymbol(symbol);

        float currentPrice = currency.getCurrentPrice();
        validateCurrencyPrice(symbol, currentPrice);

    }

    private void validateCurrencySymbol(String symbol) {
        if (CurrencyUtil.isUnsupportedCurrency(symbol)) {
            throw new UnsupportedCurrencyCreationException(symbol);
        }

        if (currencyRepository.findCurrencyBySymbol(symbol).isPresent()) {
            throw new CurrencyAlreadyExistsException(symbol);
        }
    }

    private void validateCurrencyPrice(String symbol, float currentPrice) {
        if (currentPrice < 0) {
            throw new InvalidCurrencyPriceException(symbol, currentPrice);
        }
    }

    private void setCurrencyIdAndDate(Currency currency) {
        currency.setCurrencyId(UUID.randomUUID());
        currency.setCreationTime(LocalDateTime.now());
    }

    @Override
    @Transactional
    public void deleteCurrency(String symbol) {
        currencyRepository.deleteCurrencyBySymbol(symbol).orElseThrow(() -> new NoSuchCurrencyException(symbol));
    }

    @Override
    @Transactional
    public void deleteCurrency(UUID currencyId) {
        currencyRepository.deleteCurrencyByCurrencyId(currencyId).orElseThrow(() -> new NoSuchCurrencyException(currencyId.toString()));
    }
}
