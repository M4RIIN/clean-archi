package com.lagrange.usecase.user.createUser;

import com.lagrange.entity.User;
import com.lagrange.usecase.exception.createUser.CreateUserException;

public interface CreateUserService {

    User create(String pseudo, String password) throws CreateUserException;
}
