package com.lagrange;


import com.lagrange.dao.InMemoryColocation;
import com.lagrange.dao.InMemoryUser;
import com.lagrange.usecase.createColocation.CreateColocationBoundary;
import com.lagrange.usecase.createColocation.CreateColocationInteractor;
import com.lagrange.usecase.createUser.CreateUserInteractor;
import com.lagrange.usecase.createUser.CreateUserService;
import com.lagrange.usecase.listAllColocation.ListAllColocationBoundary;
import com.lagrange.usecase.listAllColocation.ListAllColocationInteractor;
import com.lagrange.usecase.listAllUser.ListAllUserInteractor;
import com.lagrange.usecase.listAllUser.ListAllUserService;
import com.lagrange.usecase.repository.User.UserRepository;
import com.lagrange.usecase.repository.colocation.ColocationRepository;

public class Configuration {

    private static Configuration configuration = null;
    public CreateUserService createUserService;

    public ListAllUserService listAllUserService;

    private UserRepository userRepository;

    private ColocationRepository colocationRepository;

    public ListAllColocationBoundary listAllColocationBoundary;

    public CreateColocationBoundary createColocationBoundary;

    private Configuration() {
        userRepository();
        createUserService();
        listAllUserService();
        createColocationService();
    }

    public static Configuration getConfiguration(){
        if(configuration == null){
            configuration = new Configuration();
        }
        return configuration;
    }

    private void userRepository(){
      this.userRepository = new InMemoryUser();
    }


    private void listAllUserService(){
        this.listAllUserService = new ListAllUserInteractor(userRepository);
    }

    private void createUserService(){
        this.createUserService =  new CreateUserInteractor(userRepository);
    }

    private void createColocationService(){
        this.colocationRepository = new InMemoryColocation();
        this.createColocationBoundary = new CreateColocationInteractor(colocationRepository);
        this.listAllColocationBoundary = new ListAllColocationInteractor(colocationRepository);
    }

}
