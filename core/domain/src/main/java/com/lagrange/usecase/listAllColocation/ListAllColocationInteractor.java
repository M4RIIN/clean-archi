package com.lagrange.usecase.listAllColocation;

import com.lagrange.usecase.model.user.colocation.Colocation;
import com.lagrange.usecase.repository.colocation.ColocationRepository;

import java.util.List;

public class ListAllColocationInteractor implements ListAllColocationBoundary {

    private final ColocationRepository colocationRepository;

    public ListAllColocationInteractor(ColocationRepository colocationRepository) {
        this.colocationRepository = colocationRepository;
    }

    @Override
    public List<Colocation> listAll() {
        return colocationRepository.listAll();
    }
}
