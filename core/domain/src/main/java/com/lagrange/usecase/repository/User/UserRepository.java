package com.lagrange.usecase.repository.User;

import com.lagrange.usecase.model.user.UserDto;

import java.util.List;

public interface UserRepository {
    boolean exist(String pseudo);

    void save(UserDto userToSave);

    List<UserDto> listAll();
}
