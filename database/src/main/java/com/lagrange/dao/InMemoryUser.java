package com.lagrange.dao;

import com.lagrange.entity.User;
import com.lagrange.model.UserData;
import com.lagrange.usecase.exception.createUser.UserDontFindException;
import com.lagrange.usecase.user.createUser.UserCredential;
import com.lagrange.usecase.repository.User.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryUser implements UserRepository {

    private HashMap<String, UserData> inMemoryDb = new HashMap<>();

    private int keyMax = 0;
    @Override
    public boolean exist(String pseudo) {
        return inMemoryDb.values()
                .stream()
                .anyMatch(elt  -> elt.getPseudo().equals(pseudo));
    }

    @Override
    public void save(User userToSave) {
        UserData userData = new UserData(userToSave.getPseudo(), userToSave.getPseudo(), userToSave.getPassword());
        inMemoryDb.put(userData.getPseudo(),userData);
    }

    @Override
    public List<User> listAll() {
        return inMemoryDb.values().stream()
                .map(UserData::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public User getUserByPseudoAndPassword(UserCredential user) throws UserDontFindException {
      return  inMemoryDb.values()
                .stream()
                .filter(u -> u.getPseudo().equals(user.getUsername()) && u.getPassword().equals(user.getPassword()))
                .map(UserData::toDto)
                .findFirst()
                .orElseThrow(UserDontFindException::new);
    }

    @Override
    public void update(User user) {
        UserData data = new UserData(user.getPseudo(), user.getPassword(), user.getColocationTag());
        this.inMemoryDb.replace(user.getPseudo(), data);
    }
}
