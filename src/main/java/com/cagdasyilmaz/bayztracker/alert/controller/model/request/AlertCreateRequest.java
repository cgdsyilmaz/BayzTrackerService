package com.cagdasyilmaz.bayztracker.alert.controller.model.request;

import com.cagdasyilmaz.bayztracker.alert.entity.AlertStatus;
import com.cagdasyilmaz.bayztracker.alert.util.AlertValidationConstraints;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AlertCreateRequest {
	@NotBlank(message = AlertValidationConstraints.CURRENCY_NOT_VALID_MESSAGE)
	private String currency;

	@NotNull(message = AlertValidationConstraints.TARGET_PRICE_NULL_MESSAGE)
	private Float targetPrice;

	@NotNull(message = AlertValidationConstraints.STATUS_NULL_MESSAGE)
	private AlertStatus alertStatus;

}
