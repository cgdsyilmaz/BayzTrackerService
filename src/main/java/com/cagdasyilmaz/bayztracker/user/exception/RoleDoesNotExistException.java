package com.cagdasyilmaz.bayztracker.user.exception;

public class RoleDoesNotExistException extends UserException {
    public RoleDoesNotExistException(String roleName) {
        super("Role " + roleName + " does not exist");
    }
}
