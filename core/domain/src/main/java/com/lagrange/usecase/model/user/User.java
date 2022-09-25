package com.lagrange.usecase.model.user;

public class User implements UserDto {
    String pseudo;
    String password;

    public User(String pseudo, String password) {
        this.pseudo = pseudo;
        this.password = password;
    }

    @Override
    public String getPseudo() {
        return pseudo;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
