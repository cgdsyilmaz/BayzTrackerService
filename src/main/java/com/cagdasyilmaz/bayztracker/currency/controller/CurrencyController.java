package com.cagdasyilmaz.bayztracker.currency.controller;

import com.cagdasyilmaz.bayztracker.currency.service.CurrencyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CurrencyResponse>> getAllCurrencies() {
        return ResponseEntity.ok().body(currencyService.getAllCurrencies());
    }

    @GetMapping("/{currencySymbol}")
    public ResponseEntity<CurrencyResponse> getCurrency(@PathVariable String currencySymbol) {
        return ResponseEntity.ok().body(currencyService.getCurrency(currencySymbol));
    }
}
