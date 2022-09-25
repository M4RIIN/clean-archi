package com.lagrange.usecase.createColocation;

import com.lagrange.entity.ColocationEntity;
import com.lagrange.usecase.exception.colocation.PasswordColocationInvalidException;
import com.lagrange.usecase.exception.colocation.TagAlreadyExistException;
import com.lagrange.usecase.exception.createUser.PasswordInvalidException;
import com.lagrange.usecase.model.user.colocation.Colocation;
import com.lagrange.usecase.repository.colocation.ColocationRepository;

public class CreateColocationInteractor implements CreateColocationBoundary {
    private final ColocationRepository colocationRepository;

    public CreateColocationInteractor(ColocationRepository colocationRepository) {
        this.colocationRepository = colocationRepository;
    }

    @Override
    public Colocation create(String nom, String password, String tag) throws TagAlreadyExistException, PasswordColocationInvalidException {
        checkRequestIsValid(nom, password, tag);
        Colocation colocation = new Colocation(nom,password,tag);
        return colocationRepository.save(colocation);
    }

    private void checkRequestIsValid(String nom, String password, String tag) throws TagAlreadyExistException, PasswordColocationInvalidException {
        checkTagIsAvailible(tag);
        checkPasswordIsValid(nom, password, tag);
    }

    private static void checkPasswordIsValid(String nom, String password, String tag) throws PasswordColocationInvalidException {
        ColocationEntity colocationEntity = new ColocationEntity(nom, password, tag);
        if(!colocationEntity.isPasswordValid()){
            throw new PasswordColocationInvalidException();
        }
    }

    private void checkTagIsAvailible(String tag) throws TagAlreadyExistException {
        if(colocationRepository.existWithTag(tag)){
            throw new TagAlreadyExistException();
        }
    }
}
