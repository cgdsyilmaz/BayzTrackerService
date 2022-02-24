package com.cagdasyilmaz.bayztracker.alert.exception;

public class IllegalAlertStatusChangeException extends AlertException {
	public IllegalAlertStatusChangeException(String currentAlertStatus, String requestedAlertStatus) {
		super("Can not transition from current alert status " + currentAlertStatus + " to " + requestedAlertStatus);
	}
}
