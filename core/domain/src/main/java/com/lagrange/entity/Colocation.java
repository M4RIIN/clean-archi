package com.lagrange.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Colocation {
    private String nom;
    private String password;

    private String tag;

    private List<User> users;

    public Colocation(String nom, String password, String tag) {
        this.nom = nom;
        this.password = password;
        this.tag = tag;
        this.users = new ArrayList<>();
    }

    public boolean isPasswordValid(){
        return !Objects.isNull(password) && password.length() >= 5;
    }

    public List<User> getUsers() {
        return this.users;
    }

    public boolean alreadyContainUser(User userToAdd) {
        return users.contains(userToAdd);
    }

    public void addNewUser(User userToAdd) {
        this.users.add(userToAdd);
    }

    public String getTag() {
        return tag;
    }

    public String getPassword() {
        return password;
    }

    public String getPseudo() {
        return nom;
    }
}
