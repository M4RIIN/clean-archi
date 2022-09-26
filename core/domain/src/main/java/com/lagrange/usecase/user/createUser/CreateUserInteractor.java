package com.lagrange.usecase.user.createUser;

import com.lagrange.entity.User;
import com.lagrange.usecase.exception.createUser.CreateUserException;
import com.lagrange.usecase.exception.createUser.PasswordInvalidException;
import com.lagrange.usecase.exception.createUser.UserAlreadyExsit;

import com.lagrange.usecase.repository.User.UserRepository;

public class CreateUserInteractor implements CreateUserService {

    private final UserRepository userRepository;

    public CreateUserInteractor(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(String pseudo, String password) throws CreateUserException {
        checkValidityOfRequest(pseudo, password);
        User userDto = new User(pseudo,password);
        userRepository.save(userDto);
        return userDto;
    }

    private void checkValidityOfRequest(String pseudo, String password) throws UserAlreadyExsit, PasswordInvalidException {
        checkIfUserAlreadyExist(pseudo);
        checkIfPasswordIsValid(pseudo, password);
    }

    private static void checkIfPasswordIsValid(String pseudo, String password) throws PasswordInvalidException {
        User user = new User(pseudo, password);
        if(!user.isPasswordValid()){
            throw new PasswordInvalidException();
        }
    }

    private void checkIfUserAlreadyExist(String pseudo) throws UserAlreadyExsit {
        if(userRepository.exist(pseudo)){
            throw new UserAlreadyExsit();
        }
    }
}
