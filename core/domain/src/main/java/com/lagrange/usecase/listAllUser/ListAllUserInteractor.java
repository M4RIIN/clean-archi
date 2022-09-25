package com.lagrange.usecase.listAllUser;

import com.lagrange.usecase.model.user.UserDto;
import com.lagrange.usecase.repository.User.UserRepository;

import java.util.List;

public class ListAllUserInteractor implements ListAllUserService {

    private final UserRepository userRepository;

    public ListAllUserInteractor(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> listAll() {
        return userRepository.listAll();
    }
}
