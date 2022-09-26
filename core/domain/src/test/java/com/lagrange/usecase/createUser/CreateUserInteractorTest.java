package com.lagrange.usecase.createUser;

import com.lagrange.entity.User;
import com.lagrange.stub.InMemoryDatabase;
import com.lagrange.stub.InMemoryDatabaseWithUserAlreadyExisting;
import com.lagrange.usecase.user.createUser.CreateUserInteractor;
import com.lagrange.usecase.exception.createUser.CreateUserException;
import com.lagrange.usecase.exception.createUser.PasswordInvalidException;
import com.lagrange.usecase.exception.createUser.UserAlreadyExsit;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


public class CreateUserInteractorTest {

    @Test
    public void whenMyUserHavePassword123ShouldRaiseException(){
        CreateUserInteractor createUserInteractor = new CreateUserInteractor(new InMemoryDatabase());
        assertThrows(PasswordInvalidException.class, ()->{
            createUserInteractor.create("ok","123");
        }) ;
    }

    @Test
    public void whenMyUserHavePasswordIsNullShouldRaiseException(){
        CreateUserInteractor createUserInteractor = new CreateUserInteractor(new InMemoryDatabase());
        assertThrows(PasswordInvalidException.class, ()->{
            createUserInteractor.create("ok",null);
        }) ;
    }

    @Test
    public void whenMyUserAlreadyExistShouldThrowAlreadyExistException(){
        CreateUserInteractor createUserInteractor = new CreateUserInteractor(new InMemoryDatabaseWithUserAlreadyExisting());
        assertThrows(UserAlreadyExsit.class, ()->{
            createUserInteractor.create("ok","123456");
        }) ;
    }

    @Test
    public void whenSaveUserShouldSaveAndReturnSame() throws CreateUserException {
        InMemoryDatabase createUserRepository = new InMemoryDatabase();
        CreateUserInteractor createUserInteractor = new CreateUserInteractor(createUserRepository);
        String marin = "marin";
        String password = "marin123456";
        User userDto = createUserInteractor.create(marin, password);
        assertEquals(password,userDto.getPassword());
        assertEquals(marin,userDto.getPseudo());
        assertEquals(marin,createUserRepository.userDtoList.get(1).getPseudo());
        assertEquals(password,createUserRepository.userDtoList.get(1).getPassword());
    }
}

