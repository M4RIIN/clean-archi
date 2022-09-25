package com.lagrange.usecase.exception.createUser;

public class PasswordInvalidException extends CreateUserException {
    public PasswordInvalidException() {
        super("Password is invalid.");
    }
}
