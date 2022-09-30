package com.lagrange.usecase.user.joinColocation;

import com.lagrange.entity.User;
import com.lagrange.usecase.exception.colocation.ColocationNotFoundException;
import com.lagrange.usecase.exception.createUser.UserDontFindException;

public interface JoinColocationService {

    User joinColocation(User user,String tag) throws ColocationNotFoundException, UserDontFindException;
}
