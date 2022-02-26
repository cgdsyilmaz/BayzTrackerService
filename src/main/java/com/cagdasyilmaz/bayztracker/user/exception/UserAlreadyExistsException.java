package com.cagdasyilmaz.bayztracker.user.exception;

public class UserAlreadyExistsException extends UserException {
	public UserAlreadyExistsException(String username) {
		super("Username " + username + " is already taken.");
	}
}
