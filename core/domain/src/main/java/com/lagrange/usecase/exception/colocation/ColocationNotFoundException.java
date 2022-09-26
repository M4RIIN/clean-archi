package com.lagrange.usecase.exception.colocation;

public class ColocationNotFoundException extends Exception {

    public ColocationNotFoundException() {
        super("Colocation doesn't exists.");
    }
}
