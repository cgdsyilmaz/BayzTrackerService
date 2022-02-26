package com.cagdasyilmaz.bayztracker.alert.entity;

import lombok.Getter;

@Getter
public enum AlertStatus {
	NEW("NEW"), TRIGGERED("TRIGGERED"), ACKED("ACKED"), CANCELLED("CANCELLED");

	private final String alertText;

	AlertStatus(String alertText) {
		this.alertText = alertText;
	}

}
