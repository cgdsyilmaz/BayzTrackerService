package com.cagdasyilmaz.bayztracker.currency.service;

import com.cagdasyilmaz.bayztracker.currency.entity.Currency;
import java.util.List;
import java.util.UUID;

public interface CurrencyService {
	List<Currency> getAllCurrencies();
	Currency getCurrency(String symbol);
	UUID addCurrency(Currency currency);
	void deleteCurrency(String symbol);
}
