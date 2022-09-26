package com.lagrange.stub;

import com.lagrange.entity.User;
import com.lagrange.usecase.repository.User.UserRepository;
import com.lagrange.usecase.user.createUser.UserCredential;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDatabaseWithUserAlreadyExisting implements UserRepository {

    List<User> userDtoList = new ArrayList<>();

    @Override
    public boolean exist(String pseudo) {
        return true;
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
        return null;
    }
}
