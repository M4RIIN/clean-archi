package com.lagrange.usecase.exception.colocation;

public class UserAlreadyPresentInColocationException extends Exception {
    public UserAlreadyPresentInColocationException() {
        super("User already present in colocation.");
    }
}
