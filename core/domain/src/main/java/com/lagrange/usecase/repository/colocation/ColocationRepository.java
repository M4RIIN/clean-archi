package com.lagrange.usecase.repository.colocation;


import com.lagrange.entity.Colocation;

import java.util.List;

public interface ColocationRepository {
    Colocation save(Colocation colocation);
    boolean existWithTag(String tag);

    List<Colocation> listAll();

    Colocation getColocationByPseudoAndPassword(String tag, String password);

    void updateColocation(Colocation colocationJoined);
}
