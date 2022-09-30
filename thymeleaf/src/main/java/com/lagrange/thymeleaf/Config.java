package com.lagrange.thymeleaf;

import com.lagrange.dao.InMemoryColocation;
import com.lagrange.dao.InMemoryUser;
import com.lagrange.usecase.colocation.createColocation.CreateColocationInteractor;
import com.lagrange.usecase.colocation.createColocation.CreateColocationService;
import com.lagrange.usecase.colocation.listAllColocation.ListAllColocationInteractor;
import com.lagrange.usecase.colocation.listAllColocation.ListAllColocationService;
import com.lagrange.usecase.repository.User.UserRepository;
import com.lagrange.usecase.repository.colocation.ColocationRepository;
import com.lagrange.usecase.user.createUser.CreateUserInteractor;
import com.lagrange.usecase.user.createUser.CreateUserService;
import com.lagrange.usecase.user.listAllUser.ListAllUserInteractor;
import com.lagrange.usecase.user.listAllUser.ListAllUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public UserRepository userRepository(){
        return new InMemoryUser();
    }

    @Bean
    public ColocationRepository colocationRepository(){
        return new InMemoryColocation();
    }

    @Bean
    public ListAllUserService listAllUserService(UserRepository userRepository){
        return new ListAllUserInteractor(userRepository);
    }

    @Bean
    public CreateUserService createUserService(UserRepository userRepository){
        return new CreateUserInteractor(userRepository);
    }

    @Bean
    public ListAllColocationService listAllColocationService(ColocationRepository colocationRepository){
        return new ListAllColocationInteractor(colocationRepository);
    }

    @Bean
    public CreateColocationService createColocationService(ColocationRepository colocationRepository){
        return new CreateColocationInteractor(colocationRepository);
    }
}
