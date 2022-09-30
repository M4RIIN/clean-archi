package com.lagrange.model;


import com.lagrange.entity.User;

public class UserData {
    private String pseudo;
    private String password;
    private String colocTag;


    public UserData(String pseudo, String password, String colocTag) {
        this.pseudo = pseudo;
        this.password = password;
        this.colocTag = colocTag;
    }

    public User toDto(){
        return new User(pseudo,password);
    }


    public String getPseudo() {
        return pseudo;
    }

    public String getPassword() {
        return password;
    }

    public String getColocTag() {
        return colocTag;
    }

}
