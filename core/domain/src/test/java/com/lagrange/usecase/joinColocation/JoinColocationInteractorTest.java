package com.lagrange.usecase.joinColocation;


import com.lagrange.entity.Colocation;
import com.lagrange.entity.User;
import com.lagrange.stub.InMemoryDatabase;
import com.lagrange.stub.colocation.InMemoryColocationDbMock;
import com.lagrange.usecase.colocation.joinColocation.ColocationCredentials;
import com.lagrange.usecase.colocation.joinColocation.ColocationJoinInteractor;
import com.lagrange.usecase.exception.colocation.ColocationNotFoundException;
import com.lagrange.usecase.exception.createUser.UserDontFindException;
import com.lagrange.usecase.user.createUser.UserCredential;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class JoinColocationInteractorTest {

    @Test
    public void whenColocationDontExistRaiseError(){
        ColocationCredentials colocationJoined = new ColocationCredentials("invalide","1234");
        ColocationJoinInteractor colocationJoinService = new ColocationJoinInteractor(new InMemoryColocationDbMock(), new InMemoryDatabase());
        UserCredential userToAdd = new UserCredential("valid","valid");
        assertThrows(ColocationNotFoundException.class,()->{
            colocationJoinService.addUserToColocation(userToAdd,colocationJoined);
        });
    }

    @Test
    public void asUserICanJoinColocation() throws Exception {
        ColocationCredentials colocationJoined = new ColocationCredentials("1234","valide");
        InMemoryDatabase userRepository = new InMemoryDatabase();
        ColocationJoinInteractor colocationJoinService = new ColocationJoinInteractor(new InMemoryColocationDbMock(), userRepository);
        String userPseudo = "valid";
        UserCredential userToAdd = new UserCredential(userPseudo,"valid");
        Colocation colocationWithUser = colocationJoinService.addUserToColocation(userToAdd,colocationJoined);
        assertEquals(userPseudo,userRepository.getUserByPseudoAndPassword(userToAdd).getPseudo());

    }

    @Test
    public void whenUserDontExistTryToJoinColocation(){
        ColocationCredentials colocationJoined = new ColocationCredentials("invalide","1234");
        ColocationJoinInteractor colocationJoinService = new ColocationJoinInteractor(new InMemoryColocationDbMock(), new InMemoryDatabase());
        UserCredential userToAdd = new UserCredential("nonvalide","nonvalide");
        assertThrows(UserDontFindException.class,()->{
            colocationJoinService.addUserToColocation(userToAdd,colocationJoined);
        });
    }

}
