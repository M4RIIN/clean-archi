package com.lagrange.usecase.colocation.joinColocation;

import com.lagrange.entity.Colocation;
import com.lagrange.entity.User;
import com.lagrange.usecase.exception.colocation.ColocationNotFoundException;
import com.lagrange.usecase.user.createUser.UserCredential;

public interface ColocationJoinService {
    Colocation addUserToColocation(UserCredential userToAdd, ColocationCredentials colocationJoined) throws Exception;
}
