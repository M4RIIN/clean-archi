package com.lagrange.stub;

import com.lagrange.usecase.model.user.User;
import com.lagrange.usecase.model.user.UserDto;
import com.lagrange.usecase.repository.User.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDatabase implements UserRepository {

    public List<UserDto> userDtoList = new ArrayList<>();

    @Override
    public boolean exist(String pseudo) {
        return userDtoList.stream()
                .anyMatch(elt -> elt.getPseudo().equals(pseudo));
    }

    @Override
    public void save(UserDto userToSave) {
        userDtoList.add(userToSave);
    }

    @Override
    public List<UserDto> listAll() {
        return userDtoList;
    }

    public void populate(){
        this.userDtoList.add(
                new User("marin","12345")
        );
    }
}
