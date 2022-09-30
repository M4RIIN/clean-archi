package com.lagrange.usecase.colocation.createColocation;

import com.lagrange.entity.Colocation;

public interface CreateColocationService {
    Colocation create(String nom, String password, String tag) throws Exception;
}
