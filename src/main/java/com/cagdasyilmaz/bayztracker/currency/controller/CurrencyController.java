package com.cagdasyilmaz.bayztracker.currency.controller;

import com.cagdasyilmaz.bayztracker.currency.controller.mapper.CurrencyMapper;
import com.cagdasyilmaz.bayztracker.currency.controller.model.request.CurrencyCreateRequest;
import com.cagdasyilmaz.bayztracker.currency.controller.model.response.CurrencyResponse;
import com.cagdasyilmaz.bayztracker.currency.entity.Currency;
import com.cagdasyilmaz.bayztracker.currency.service.CurrencyService;
import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/currencies")
public class CurrencyController {
    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping()
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

	@GetMapping("/{currencyId}")
	public ResponseEntity<CurrencyResponse> getCurrency(@PathVariable UUID currencyId) {
		return ResponseEntity.ok().body(CurrencyMapper.mapCurrencyToCurrencyResponse(currencyService.getCurrency(currencyId)));
	}

    @PostMapping("/add")
	public ResponseEntity<String> addCurrency(@RequestBody @Validated CurrencyCreateRequest currencyCreateRequest) {
    	UUID currencyId = currencyService.addCurrency(CurrencyMapper.mapCurrencyCreateRequestToCurrency(currencyCreateRequest));
    	return ResponseEntity.created(URI.create("/v1/currencies/" + currencyId)).build();
	}

	@DeleteMapping("/{symbol}")
    public ResponseEntity<String> deleteCurrency(@PathVariable String symbol) {
        currencyService.deleteCurrency(symbol.toUpperCase());
        return ResponseEntity.ok().build();
    }

	@DeleteMapping("/{currencyId}")
	public ResponseEntity<String> deleteCurrency(@PathVariable UUID currencyId) {
		currencyService.deleteCurrency(currencyId);
		return ResponseEntity.ok().build();
	}
}
