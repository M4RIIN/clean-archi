package com.lagrange.thymeleaf.controller;

public class UserForm {
    public String pseudo;
    public String password;

    public UserForm() {
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
