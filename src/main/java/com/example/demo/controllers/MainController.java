package com.example.demo.controllers;

import com.example.demo.entities.Role;
import com.example.demo.repositories.RoleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {

    private final RoleRepository repository;


    public MainController(RoleRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public String index(Model model) {
        return "layout";
    }

    @GetMapping("/register")
    public String register(Model model) {

        List<Role> roles = new ArrayList<>();
        repository.findAll()
                .stream().filter(role -> role.getId() != 1)
                .forEach(roles::add);

        model.addAttribute("roles", roles);

        return "register";
    }
}
