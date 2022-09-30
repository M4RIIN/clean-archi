package com.lagrange.usecase.user.joinColocation;

import com.lagrange.entity.User;
import com.lagrange.usecase.exception.colocation.ColocationNotFoundException;
import com.lagrange.usecase.exception.createUser.UserDontFindException;
import com.lagrange.usecase.repository.User.UserRepository;
import com.lagrange.usecase.repository.colocation.ColocationRepository;
import com.lagrange.usecase.user.createUser.UserCredential;

public class JoinColocationInteractor implements JoinColocationService {

    private final ColocationRepository colocationRepository;
    private final UserRepository userRepository;

    public JoinColocationInteractor(ColocationRepository colocationRepository, UserRepository userRepository) {
        this.colocationRepository = colocationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public User joinColocation(User user,String tag) throws ColocationNotFoundException, UserDontFindException {
        if (!colocationRepository.existWithTag(tag)){
            throw new ColocationNotFoundException();
        }
        UserCredential userCredential = new UserCredential(user.getPseudo(), user.getPassword());
        User userToUpdate = userRepository.getUserByPseudoAndPassword(userCredential);
        userToUpdate.joinColocation(tag);
        userRepository.update(user);
        return userToUpdate;

    }
}
