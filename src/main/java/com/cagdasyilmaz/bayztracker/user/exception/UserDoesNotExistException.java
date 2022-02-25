package com.cagdasyilmaz.bayztracker.user.exception;

public class UserDoesNotExistException extends UserException {
    public UserDoesNotExistException(String username) {
        super("User " + username + " does not exist");
    }
}