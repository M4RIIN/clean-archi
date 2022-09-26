package com.lagrange.usecase.user.listAllUser;


import com.lagrange.entity.User;
import com.lagrange.usecase.repository.User.UserRepository;

import java.util.List;

public class ListAllUserInteractor implements ListAllUserService {

    private final UserRepository userRepository;

    public ListAllUserInteractor(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> listAll() {
        return userRepository.listAll();
    }
}
