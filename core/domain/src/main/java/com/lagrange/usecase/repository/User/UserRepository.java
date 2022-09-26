package com.lagrange.usecase.repository.User;

import com.lagrange.entity.User;
import com.lagrange.usecase.user.createUser.UserCredential;

import java.util.List;

public interface UserRepository {
    boolean exist(String pseudo);

    void save(User userToSave);

    List<User> listAll();

    User getUserByPseudoAndPassword(UserCredential user);
}
