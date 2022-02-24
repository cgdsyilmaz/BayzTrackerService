package com.cagdasyilmaz.bayztracker.alert.entity;

import com.cagdasyilmaz.bayztracker.alert.exception.UnrecognizedAlarmStatusException;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Arrays;
import lombok.Getter;

@Getter
public enum AlarmStatus {
	NEW("NEW"), TRIGGERED("TRIGGERED"), ACKED("ACKED"), CANCELLED("CANCELLED");

	private String alarmText;

	AlarmStatus(String alarmText) {
		this.alarmText = alarmText;
	}

	@Override
	public String toString() {
		return alarmText;
	}

	@JsonCreator
	public static AlarmStatus fromText(String alarmText) {
		String alarmTextAllCaps = alarmText.toUpperCase();
		return Arrays.stream(AlarmStatus.values())
			.filter(status -> status.getAlarmText().equals(alarmTextAllCaps))
			.findAny()
			.orElseThrow(() -> new UnrecognizedAlarmStatusException(alarmTextAllCaps));
	}
}
