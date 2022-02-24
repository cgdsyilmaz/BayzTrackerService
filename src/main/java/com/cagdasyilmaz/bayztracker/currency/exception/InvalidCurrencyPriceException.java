package com.cagdasyilmaz.bayztracker.currency.exception;

public class InvalidCurrencyPriceException extends CurrencyException {
	public InvalidCurrencyPriceException(String symbol, float price) {
		super("Currency " + symbol + "'s price can not be " + price);
	}
}
