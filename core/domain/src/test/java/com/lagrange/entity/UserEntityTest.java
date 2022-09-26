package com.lagrange.entity;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserEntityTest {

    @Test
    public void passwordNullIsNotValid(){
        UserEntity userEntity = createUser(null);
        assertFalse(userEntity.isPasswordValid());
    }

    @Test
    public void password1234IsNotValidPassword(){
        UserEntity userEntity = createUser("1234");
        assertFalse(userEntity.isPasswordValid());
    }


    @Test
    public void password12345IsValidPassword(){
        UserEntity userEntity = createUser("12345");
        assertTrue(userEntity.isPasswordValid());
    }

    private static UserEntity createUser(String password) {
        UserEntity userEntity = new UserEntity("marin", password);
        return userEntity;
    }
}