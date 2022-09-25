package com.lagrange.entity;

import java.util.Objects;

public class UserEntity {
    private String login;
    private String password;

    public UserEntity(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public boolean isPasswordValid(){
        return !Objects.isNull(password) && password.length() >= 5;
    }



}
