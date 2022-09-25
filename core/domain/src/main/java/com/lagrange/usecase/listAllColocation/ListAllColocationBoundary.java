package com.lagrange.usecase.listAllColocation;

import com.lagrange.usecase.model.user.colocation.Colocation;

import java.util.List;

public interface ListAllColocationBoundary {
    List<Colocation> listAll();
}
