package com.lagrange.usecase.repository.colocation;

import com.lagrange.usecase.model.user.colocation.Colocation;

import java.util.List;

public interface ColocationRepository {
    Colocation save(Colocation colocation);
    boolean existWithTag(String tag);

    List<Colocation> listAll();
}
