package com.cagdasyilmaz.bayztracker.alert.exception;

public class UnrecognizedAlarmStatusException extends AlarmException {
	public UnrecognizedAlarmStatusException(String unrecognizedAlarmStatus) {
		super("Unrecognized alarm status: " + unrecognizedAlarmStatus);
	}
}
