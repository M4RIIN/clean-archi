package com.lagrange.entity;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserTest {

    @Test
    public void passwordNullIsNotValid(){
        User user = createUser(null);
        assertFalse(user.isPasswordValid());
    }

    @Test
    public void password1234IsNotValidPassword(){
        User user = createUser("1234");
        assertFalse(user.isPasswordValid());
    }


    @Test
    public void password12345IsValidPassword(){
        User user = createUser("12345");
        assertTrue(user.isPasswordValid());
    }

    private static User createUser(String password) {
        User user = new User("marin", password);
        return user;
    }
}