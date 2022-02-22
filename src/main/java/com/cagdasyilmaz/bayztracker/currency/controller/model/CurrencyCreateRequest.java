package com.cagdasyilmaz.bayztracker.currency.controller.model;

import com.cagdasyilmaz.bayztracker.currency.util.CurrencyValidationConstraints;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CurrencyCreateRequest {
	@NotBlank(message = CurrencyValidationConstraints.NAME_NOT_VALID_MESSAGE)
	private String name;

	@NotBlank(message = CurrencyValidationConstraints.SYMBOL_NOT_VALID_MESSAGE)
	private String symbol;

	private float currentPrice;
}
