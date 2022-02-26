package com.cagdasyilmaz.bayztracker.alert.controller.model.request;

import com.cagdasyilmaz.bayztracker.alert.util.AlertValidationConstraints;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AlertEditRequest {
	@NotNull(message = AlertValidationConstraints.TARGET_PRICE_NULL_MESSAGE)
	private Float targetPrice;
}
