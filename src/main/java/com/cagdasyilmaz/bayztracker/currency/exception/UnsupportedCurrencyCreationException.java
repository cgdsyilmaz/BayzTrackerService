package com.cagdasyilmaz.bayztracker.currency.exception;

public class UnsupportedCurrencyCreationException extends CurrencyException {
    public UnsupportedCurrencyCreationException(String currency) {
        super("Unsupported currency creation request for: " + currency + " received!");
    }
}
