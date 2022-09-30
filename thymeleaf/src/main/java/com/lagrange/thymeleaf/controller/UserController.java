package com.lagrange.thymeleaf.controller;

import com.lagrange.entity.User;
import com.lagrange.usecase.exception.createUser.CreateUserException;
import com.lagrange.usecase.user.createUser.CreateUserService;
import com.lagrange.usecase.user.listAllUser.ListAllUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {


    private final ListAllUserService listAllUserService;
    private final CreateUserService createUserService;

    private List<User> userList = new ArrayList<>();

    public UserController(ListAllUserService listAllUserService, CreateUserService createUserService) {
        this.listAllUserService = listAllUserService;
        this.createUserService = createUserService;
        userList = listAllUserService.listAll();
    }

    @GetMapping("/userList")
    public String userList(Model model){
        userList = listAllUserService.listAll();
        model.addAttribute("userList",userList);
        return "userList";
    }

    @GetMapping("/addUser")
    public String addUser(Model model){
        UserForm userForm = new UserForm();
        model.addAttribute("userForm",userForm);
        return "addUser";
    }

    @PostMapping("/addUser")
    public String saveUser(@ModelAttribute("userForm") UserForm userForm,Model
                            model){
        try {
            createUserService.create(userForm.pseudo,userForm.password);
        } catch (CreateUserException e) {
            model.addAttribute("errorMessage",e.getMessage());
            return "addUser";
        }
        return "redirect:/userList";
    }


}
