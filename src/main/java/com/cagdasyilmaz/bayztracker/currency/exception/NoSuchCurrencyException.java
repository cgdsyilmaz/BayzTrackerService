package com.cagdasyilmaz.bayztracker.currency.exception;

public class NoSuchCurrencyException extends CurrencyException {
	public NoSuchCurrencyException(String currency) {
		super("No such currency: " + currency);
	}
}
