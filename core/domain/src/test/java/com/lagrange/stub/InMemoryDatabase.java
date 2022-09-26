package com.lagrange.stub;

import com.lagrange.entity.User;

import com.lagrange.usecase.repository.User.UserRepository;
import com.lagrange.usecase.user.createUser.UserCredential;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDatabase implements UserRepository {

    public List<User> userDtoList = new ArrayList<>();

    public InMemoryDatabase() {
        populate();
    }

    @Override
    public boolean exist(String pseudo) {
        return userDtoList.stream()
                .anyMatch(elt -> elt.getPseudo().equals(pseudo));
    }

    @Override
    public void save(User userToSave) {
        userDtoList.add(userToSave);
    }

    @Override
    public List<User> listAll() {
        return userDtoList;
    }

    @Override
    public User getUserByPseudoAndPassword(UserCredential user) {
        return userDtoList.stream()
                .filter(u -> u.getPseudo().equals(user.getUsername()) && u.getPassword().equals(user.getPassword()))
                .findFirst()
                .orElse(null);
    }

    public void populate(){
        this.userDtoList.add(
                new User("valid","valid")
        );
    }
}
