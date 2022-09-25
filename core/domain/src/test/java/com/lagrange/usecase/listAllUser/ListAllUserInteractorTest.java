package com.lagrange.usecase.listAllUser;

import com.lagrange.stub.InMemoryDatabase;
import com.lagrange.usecase.model.user.UserDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListAllUserInteractorTest {

    @Test
    public void returnAllSavedUser(){
        InMemoryDatabase inMemoryDatabase = new InMemoryDatabase();

        ListAllUserInteractor listAllUserInteractor = new ListAllUserInteractor(inMemoryDatabase);

        List<UserDto> userDtoList = listAllUserInteractor.listAll();

        assertEquals(userDtoList.size(),inMemoryDatabase
                .userDtoList.size());
    }

}