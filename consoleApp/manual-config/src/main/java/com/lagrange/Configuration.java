package com.lagrange;


import com.lagrange.dao.InMemoryColocation;
import com.lagrange.dao.InMemoryUser;
import com.lagrange.usecase.colocation.createColocation.CreateColocationService;
import com.lagrange.usecase.colocation.createColocation.CreateColocationInteractor;
import com.lagrange.usecase.user.createUser.CreateUserInteractor;
import com.lagrange.usecase.user.createUser.CreateUserService;
import com.lagrange.usecase.colocation.joinColocation.ColocationJoinService;
import com.lagrange.usecase.colocation.joinColocation.ColocationJoinInteractor;
import com.lagrange.usecase.colocation.listAllColocation.ListAllColocationService;
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

    public ListAllColocationService listAllColocationService;

    public CreateColocationService createColocationService;

    public ColocationJoinService colocationJoinService;

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
        this.createColocationService = new CreateColocationInteractor(colocationRepository);
        this.listAllColocationService = new ListAllColocationInteractor(colocationRepository);
        this.colocationJoinService = new ColocationJoinInteractor(colocationRepository, userRepository);
    }

}
