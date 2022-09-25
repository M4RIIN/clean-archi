package com.lagrange.usecase.exception.colocation;

public class PasswordColocationInvalidException extends Exception {
    public PasswordColocationInvalidException() {
        super("Password must have 5 or more characters.");
    }
}
