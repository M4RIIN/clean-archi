package com.lagrange;


import com.lagrange.dao.InMemoryColocation;
import com.lagrange.dao.InMemoryUser;
import com.lagrange.usecase.colocation.createColocation.CreateColocationBoundary;
import com.lagrange.usecase.colocation.createColocation.CreateColocationInteractor;
import com.lagrange.usecase.user.createUser.CreateUserInteractor;
import com.lagrange.usecase.user.createUser.CreateUserService;
import com.lagrange.usecase.colocation.joinColocation.ColocationJoinBoundary;
import com.lagrange.usecase.colocation.joinColocation.ColocationJoinInteractor;
import com.lagrange.usecase.colocation.listAllColocation.ListAllColocationBoundary;
import com.lagrange.usecase.colocation.listAllColocation.ListAllColocationInteractor;
import com.lagrange.usecase.user.listAllUser.ListAllUserInteractor;
import com.lagrange.usecase.user.listAllUser.ListAllUserService;
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

    public ColocationJoinBoundary colocationJoinBoundary;

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
        this.colocationJoinBoundary = new ColocationJoinInteractor(colocationRepository, userRepository);
    }

}
