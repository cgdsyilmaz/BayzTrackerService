package com.cagdasyilmaz.bayztracker.alert.exception;

import java.util.UUID;

public class NoSuchAlertException extends AlertException {
	public NoSuchAlertException(UUID alertId) {
		super("There is no such alert with id: " + alertId.toString());
	}

}
