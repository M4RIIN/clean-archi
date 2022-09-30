package com.lagrange.usecase.colocation.joinColocation;

import com.lagrange.entity.Colocation;
import com.lagrange.entity.User;
import com.lagrange.usecase.exception.colocation.UserAlreadyPresentInColocationException;
import com.lagrange.usecase.exception.createUser.UserDontFindException;
import com.lagrange.usecase.exception.colocation.ColocationNotFoundException;
import com.lagrange.usecase.repository.User.UserRepository;
import com.lagrange.usecase.repository.colocation.ColocationRepository;
import com.lagrange.usecase.user.createUser.UserCredential;

import java.util.Objects;

public class ColocationJoinInteractor implements ColocationJoinService {

    private final ColocationRepository colocationRepository;
    private final UserRepository userRepository;

    public ColocationJoinInteractor(ColocationRepository colocationRepository, UserRepository userRepository) {
        this.colocationRepository = colocationRepository;
        this.userRepository = userRepository;
    }

    public Colocation addUserToColocation(UserCredential userCredentials, ColocationCredentials colocationCredentials) throws Exception {
        User userToAdd = userRepository.getUserByPseudoAndPassword(userCredentials);
        if(Objects.isNull(userToAdd)){
            throw new UserDontFindException();
        }
        Colocation colocationJoined = colocationRepository.getColocationByPseudoAndPassword(colocationCredentials.getTag(),colocationCredentials.getPassword());
        if(Objects.isNull(colocationJoined)){
            throw new ColocationNotFoundException();
        }

        if(!colocationJoined.alreadyContainUser(userToAdd)){
            colocationJoined.addNewUser(userToAdd);
            colocationRepository.updateColocation(colocationJoined);
        }else{
            throw new UserAlreadyPresentInColocationException();
        }


        return colocationJoined;
    }
}
