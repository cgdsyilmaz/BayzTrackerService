package com.cagdasyilmaz.bayztracker.currency.controller.model.response;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Data;

@Data
public class CurrencyResponse {
	private UUID currencyId;
	private String name;
	private String symbol;
	private float currentPrice;
	private boolean isEnabled;
	private LocalDateTime creationTime;
}
