package com.cagdasyilmaz.bayztracker.alert.entity;

import com.cagdasyilmaz.bayztracker.alert.exception.UnrecognizedAlertStatusException;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Arrays;
import lombok.Getter;

@Getter
public enum AlertStatus {
	NEW("NEW"), TRIGGERED("TRIGGERED"), ACKED("ACKED"), CANCELLED("CANCELLED");

	private String alertText;

	AlertStatus(String alertText) {
		this.alertText = alertText;
	}

	@Override
	public String toString() {
		return alertText;
	}

	@JsonCreator
	public static AlertStatus fromText(String alertText) {
		String alertTextAllCaps = alertText.toUpperCase();
		return Arrays.stream(AlertStatus.values())
			.filter(status -> status.getAlertText().equals(alertTextAllCaps))
			.findAny()
			.orElseThrow(() -> new UnrecognizedAlertStatusException(alertTextAllCaps));
	}
}
