package com.lagrange.entity;

import java.util.Objects;

public class User {
    private String pseudo;
    private String password;
    private String colocationTag;

    public User(String pseudo, String password) {
        this.pseudo = pseudo;
        this.password = password;
        this.colocationTag = "";
    }

    public void joinColocation(String tag){
        this.colocationTag = tag;
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

    public String getColocationTag() {
        return colocationTag;
    }
}
