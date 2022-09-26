package com.lagrange.model;


import com.lagrange.entity.User;

public class UserData {
    private int id;
    private String pseudo;
    private String password;

    public UserData(int id, String pseudo, String password) {
        this.id = id;
        this.pseudo = pseudo;
        this.password = password;
    }

    public User toDto(){
        return new User(pseudo,password);
    }

    public int getId() {
        return id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getPassword() {
        return password;
    }
}
