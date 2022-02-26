package com.cagdasyilmaz.bayztracker.alert.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "alerts")
public class Alert {
	@Id
	private UUID alertId;
	private String username;
	private String currency;
	private float targetPrice;
	private LocalDateTime createdAt;
	private AlertStatus status;
}
