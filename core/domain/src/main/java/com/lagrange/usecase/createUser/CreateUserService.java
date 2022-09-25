package com.lagrange.usecase.createUser;

import com.lagrange.usecase.exception.createUser.CreateUserException;
import com.lagrange.usecase.model.user.UserDto;

public interface CreateUserService {

    UserDto create(String pseudo, String password) throws CreateUserException;
}
