package com.lagrange.entity;

import java.util.Objects;

public class User {
    private String pseudo;
    private String password;

    public User(String pseudo, String password) {
        this.pseudo = pseudo;
        this.password = password;
    }

    public boolean isPasswordValid(){
        return !Objects.isNull(password) && password.length() >= 5;
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getPassword() {
        return password;
    }
}
