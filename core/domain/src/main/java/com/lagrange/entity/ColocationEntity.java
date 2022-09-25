package com.lagrange.entity;

import java.util.Objects;

public class ColocationEntity {
    private String nom;
    private String password;

    private String tag;

    public ColocationEntity(String nom, String password, String tag) {
        this.nom = nom;
        this.password = password;
        this.tag = tag;
    }

    public boolean isPasswordValid(){
        return !Objects.isNull(password) && password.length() >= 5;
    }
}
