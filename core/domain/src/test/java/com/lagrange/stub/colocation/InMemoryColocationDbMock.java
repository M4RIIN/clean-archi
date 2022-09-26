package com.lagrange.stub.colocation;

import com.lagrange.entity.Colocation;
import com.lagrange.usecase.repository.colocation.ColocationRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class InMemoryColocationDbMock implements ColocationRepository {

    private HashMap<String, Colocation> inMemoryTableColocation = new HashMap<>();

    public InMemoryColocationDbMock() {
        this.inMemoryTableColocation = inMemoryTableColocation;
        populate();
    }

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

    @Override
    public Colocation getColocationByPseudoAndPassword(String tag, String password) {
        Colocation firstFind = inMemoryTableColocation.get(tag);
        if(Objects.isNull(firstFind)){
            return null;
        }
        if(firstFind.getPassword().equals(password)){
            return firstFind;
        }else return null;
    }

    @Override
    public void updateColocation(Colocation colocationJoined) {
        this.inMemoryTableColocation.replace(colocationJoined.getTag(), colocationJoined);
    }

    private void populate(){
        this.inMemoryTableColocation.put("1234",new Colocation("valide","valide","1234"));
    }
}