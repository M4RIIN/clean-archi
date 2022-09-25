package com.lagrange.dao;

import com.lagrange.model.UserData;
import com.lagrange.usecase.model.user.UserDto;
import com.lagrange.usecase.repository.User.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryUser implements UserRepository {

    private HashMap<Integer, UserData> inMemoryDb = new HashMap<>();

    private int keyMax = 0;
    @Override
    public boolean exist(String pseudo) {
        return inMemoryDb.values()
                .stream()
                .anyMatch(elt  -> elt.getPseudo().equals(pseudo));
    }

    @Override
    public void save(UserDto userToSave) {
        UserData userData = new UserData(keyMax,userToSave.getPseudo(), userToSave.getPassword());
        inMemoryDb.put(keyMax,userData);
        keyMax++;
    }

    @Override
    public List<UserDto> listAll() {
        return inMemoryDb.values().stream()
                .map(UserData::toDto)
                .collect(Collectors.toList());
    }
}
