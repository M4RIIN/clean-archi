package com.lagrange.usecase.exception.createUser;

public class UserDontFindException extends Exception {
    public UserDontFindException() {
        super("User dont find.");
    }
}
