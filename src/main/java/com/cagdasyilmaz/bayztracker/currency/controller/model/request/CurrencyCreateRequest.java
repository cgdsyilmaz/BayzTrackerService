package com.cagdasyilmaz.bayztracker.currency.controller.model.request;

import com.cagdasyilmaz.bayztracker.currency.util.CurrencyValidationConstraints;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CurrencyCreateRequest {
	@NotBlank(message = CurrencyValidationConstraints.NAME_NOT_VALID_MESSAGE)
	private String name;

	@NotBlank(message = CurrencyValidationConstraints.SYMBOL_NOT_VALID_MESSAGE)
	private String symbol;

	@NotNull(message = CurrencyValidationConstraints.CURRENT_PRICE_NULL_MESSAGE)
	private Float currentPrice;

	@NotNull(message = CurrencyValidationConstraints.ENABLED_NULL_MESSAGE)
	private Boolean isEnabled;
}
