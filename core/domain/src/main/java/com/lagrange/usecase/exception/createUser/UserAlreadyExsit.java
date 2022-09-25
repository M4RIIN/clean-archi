package com.lagrange.usecase.exception.createUser;

public class UserAlreadyExsit extends CreateUserException {
    public UserAlreadyExsit() {
        super("User already exist.");
    }
}
