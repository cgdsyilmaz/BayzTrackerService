package com.cagdasyilmaz.bayztracker.currency.exception;

public class CurrencyAlreadyExistsException extends CurrencyException {
	public CurrencyAlreadyExistsException(String symbol) {
		super("Currency with symbol: " + symbol + " already exists!");
	}
}
