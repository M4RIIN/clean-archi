package com.lagrange.usecase.colocation.listAllColocation;

import com.lagrange.entity.Colocation;
import com.lagrange.usecase.repository.colocation.ColocationRepository;

import java.util.List;

public class ListAllColocationInteractor implements ListAllColocationService {

    private final ColocationRepository colocationRepository;

    public ListAllColocationInteractor(ColocationRepository colocationRepository) {
        this.colocationRepository = colocationRepository;
    }

    @Override
    public List<Colocation> listAll() {
        return colocationRepository.listAll();
    }
}
