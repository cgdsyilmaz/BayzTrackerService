package com.cagdasyilmaz.bayztracker.alert.exception;

public class UnrecognizedAlertStatusException extends AlertException {
	public UnrecognizedAlertStatusException(String unrecognizedAlertStatus) {
		super("Unrecognized alert status: " + unrecognizedAlertStatus);
	}
}
