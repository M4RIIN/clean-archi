package com.lagrange.dao;

import com.lagrange.model.ColocationData;
import com.lagrange.usecase.model.user.colocation.Colocation;
import com.lagrange.usecase.repository.colocation.ColocationRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryColocation implements ColocationRepository {

    private HashMap<String, Colocation> inMemoryTableColocation = new HashMap<>();

    @Override
    public Colocation save(Colocation colocation) {
        inMemoryTableColocation.put(colocation.getTag(),colocation);
        return colocation;
    }

    @Override
    public boolean existWithTag(String tag) {
        return inMemoryTableColocation.containsKey(tag);
    }

    @Override
    public List<Colocation> listAll() {
        return new ArrayList<>(inMemoryTableColocation.values());
    }
}
