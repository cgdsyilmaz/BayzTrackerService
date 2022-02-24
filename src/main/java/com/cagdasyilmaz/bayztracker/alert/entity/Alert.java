package com.cagdasyilmaz.bayztracker.alert.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "alert")
public class Alert {
	@Id
	private UUID alertId;

	private String currency;
	private float targetPrice;
	private LocalDateTime createdAt;
	private AlarmStatus status;
}
