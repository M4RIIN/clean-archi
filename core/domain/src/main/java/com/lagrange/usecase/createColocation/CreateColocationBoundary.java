package com.lagrange.usecase.createColocation;

import com.lagrange.usecase.exception.colocation.PasswordColocationInvalidException;
import com.lagrange.usecase.exception.colocation.TagAlreadyExistException;
import com.lagrange.usecase.model.user.colocation.Colocation;

public interface CreateColocationBoundary {
    Colocation create(String nom, String password,String tag) throws Exception;
}
