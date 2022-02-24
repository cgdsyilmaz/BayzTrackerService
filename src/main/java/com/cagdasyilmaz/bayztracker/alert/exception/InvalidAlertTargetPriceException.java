package com.cagdasyilmaz.bayztracker.alert.exception;

public class InvalidAlertTargetPriceException extends AlertException {
	public InvalidAlertTargetPriceException(float targetPrice) {
		super("Target price is " + targetPrice + " .It must be greater than 0");
	}

}
