package com.lagrange.thymeleaf.controller;

import com.lagrange.entity.Colocation;
import com.lagrange.usecase.colocation.createColocation.CreateColocationService;
import com.lagrange.usecase.colocation.listAllColocation.ListAllColocationService;
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
public class ColocController {


    private final ListAllColocationService listAllColocationService;
    private final CreateColocationService createColocationService;

    private List<Colocation> colocList = new ArrayList<>();

    public ColocController(ListAllColocationService listAllColocationService, CreateColocationService createColocationService) {
        this.listAllColocationService = listAllColocationService;
        this.createColocationService = createColocationService;
        colocList = listAllColocationService.listAll();
    }

    @GetMapping("/colocList")
    public String colocList(Model model){
        colocList = listAllColocationService.listAll();
        model.addAttribute("colocList", colocList);
        return "colocList";
    }

    @GetMapping("/addColoc")
    public String addColoc(Model model){
        ColocForm colocForm = new ColocForm();
        model.addAttribute("colocForm",colocForm);
        return "addColoc";
    }

    @PostMapping("/addColoc")
    public String saveUser(@ModelAttribute("colocForm") ColocForm colocForm,Model
                            model){

        try {
            createColocationService.create(colocForm.pseudo,colocForm.password,colocForm.tag);
        } catch (Exception e) {
            model.addAttribute("errorMessage",e.getMessage());
            return "addColoc";
        }

        return "redirect:/colocList";
    }


}
