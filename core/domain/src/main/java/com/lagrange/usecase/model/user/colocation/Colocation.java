package com.lagrange.usecase.model.user.colocation;

public class Colocation {
    private String pseudo;
    private String password;

    public String getTag() {
        return tag;
    }

    private String tag;
    public Colocation(String pseudo, String password, String tag) {
        this.pseudo = pseudo;
        this.password = password;
        this.tag = tag;
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getPassword() {
        return password;
    }
}
