package com.lagrange.usecase.colocation.listAllColocation;



import com.lagrange.entity.Colocation;

import java.util.List;

public interface ListAllColocationBoundary {
    List<Colocation> listAll();
}
