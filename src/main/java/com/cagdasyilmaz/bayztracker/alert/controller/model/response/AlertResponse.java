package com.cagdasyilmaz.bayztracker.alert.controller.model.response;

import com.cagdasyilmaz.bayztracker.alert.entity.AlertStatus;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Data;

@Data
public class AlertResponse {
	private UUID alertId;

	private String currency;
	private float targetPrice;
	private LocalDateTime createdAt;
	private AlertStatus status;
}
