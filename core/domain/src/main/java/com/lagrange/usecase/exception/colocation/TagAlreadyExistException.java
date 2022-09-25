package com.lagrange.usecase.exception.colocation;

public class TagAlreadyExistException extends Exception {
    public TagAlreadyExistException() {
        super("Colocation with this tag already exist.");
    }
}
