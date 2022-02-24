package com.cagdasyilmaz.bayztracker.currency.controller;

import com.cagdasyilmaz.bayztracker.currency.controller.mapper.CurrencyMapper;
import com.cagdasyilmaz.bayztracker.currency.controller.model.request.CurrencyCreateRequest;
import com.cagdasyilmaz.bayztracker.currency.controller.model.response.CurrencyResponse;
import com.cagdasyilmaz.bayztracker.currency.entity.Currency;
import com.cagdasyilmaz.bayztracker.currency.service.CurrencyService;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        List<Currency> currencies = currencyService.getAllCurrencies();
        List<CurrencyResponse> currencyResponses = currencies.stream()
            .map(CurrencyMapper::mapCurrencyToCurrencyResponse)
            .collect(Collectors.toList());

        return ResponseEntity.ok().body(currencyResponses);
    }

    @GetMapping("/{symbol}")
    public ResponseEntity<CurrencyResponse> getCurrency(@PathVariable String symbol) {
        return ResponseEntity.ok().body(CurrencyMapper.mapCurrencyToCurrencyResponse(currencyService.getCurrency(symbol.toUpperCase())));
    }

    @PutMapping("/add")
	public ResponseEntity<UUID> addCurrency(@RequestBody @Validated CurrencyCreateRequest currencyCreateRequest) {
    	UUID currencyId = currencyService.addCurrency(CurrencyMapper.mapCurrencyCreateRequestToCurrency(currencyCreateRequest));
    	return ResponseEntity.ok().body(currencyId);
	}

	@DeleteMapping("/delete")
    public void deleteCurrency(@RequestParam String symbol) {
        currencyService.deleteCurrency(symbol.toUpperCase());
    }
}
