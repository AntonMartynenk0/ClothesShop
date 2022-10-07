package com.example.demo.controllers;


import com.example.demo.services.RoleService;
import com.example.demo.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    RoleService roleService;
    UserService userService;

    public RegistrationController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("")
    public String register(Model model) {
        model.addAttribute("roles", roleService.getAll());
        return "register";
    }

    @GetMapping("/new-user")
    public String registerUser(@RequestParam(value = "name", required = false) String name,
                               @RequestParam(value = "surname", required = false) String surname,
                               @RequestParam(value = "email", required = false) String email,
                               @RequestParam(value = "phone", required = false) String phone,
                               @RequestParam(value = "password", required = false) String password,
                               @RequestParam(value = "sellerRole", required = false) String sellerRole,
                               @RequestParam(value = "buyerRole", required = false) String buyerRole) {
        String role = Objects.equals(sellerRole, "on") ? "Seller" : "Buyer";
        return userService.addUser(name, surname, email, phone, password, role) ? "successful" : "unsuccessful";
    }
}