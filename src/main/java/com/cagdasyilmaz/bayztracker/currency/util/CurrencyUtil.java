package com.cagdasyilmaz.bayztracker.currency.util;

import java.util.Arrays;

public class CurrencyUtil {
    private static final String[] UNSUPPORTED_CURRENCIES = {"ETH", "LTC", "ZKN", "MRD", "LPR", "GBZ"};
    public static boolean isUnsupportedCurrency(String currency) {
        return Arrays.asList(UNSUPPORTED_CURRENCIES).contains(currency);
    }
}
