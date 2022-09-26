package com.lagrange.usecase.listAllUser;

import com.lagrange.entity.User;
import com.lagrange.stub.InMemoryDatabase;
import com.lagrange.usecase.user.listAllUser.ListAllUserInteractor;
import org.junit.Test;


import java.util.List;

import static org.junit.Assert.assertEquals;


public class ListAllUserInteractorTest {

    @Test
    public void returnAllSavedUser(){
        InMemoryDatabase inMemoryDatabase = new InMemoryDatabase();

        ListAllUserInteractor listAllUserInteractor = new ListAllUserInteractor(inMemoryDatabase);

        List<User> userDtoList = listAllUserInteractor.listAll();

        assertEquals(userDtoList.size(),inMemoryDatabase
                .userDtoList.size());
    }

}