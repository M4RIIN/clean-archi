package com.lagrange.stub;

import com.lagrange.usecase.model.user.UserDto;
import com.lagrange.usecase.repository.User.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDatabaseWithUserAlreadyExisting implements UserRepository {

    List<UserDto> userDtoList = new ArrayList<>();

    @Override
    public boolean exist(String pseudo) {
        return true;
    }

    @Override
    public void save(UserDto userToSave) {
        userDtoList.add(userToSave);
    }

    @Override
    public List<UserDto> listAll() {
        return userDtoList;
    }
}
