package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    @Autowired
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    private String styleDisplayMessage = "display_message";    //styles for message div
    private String messageText = "message";    //text for message adout

    @GetMapping("/sign/in")
    public String login(Model model) {
        model.addAttribute(messageText, "");
        model.addAttribute(styleDisplayMessage, "display: none");
        return "/sign/in";
    }

    @PostMapping("/sign/in/error")
    public String error(Model model) {
        model.addAttribute(styleDisplayMessage, "display: flex; align-items: center; background-color: #ff00008c");
        model.addAttribute(messageText, "Invalid email or password! Try Again");
        return "/sign/in";
    }

    @GetMapping("/sign/up")
    public String registration(Model model) {
        model.addAttribute(styleDisplayMessage, "display: none");
        return "/sign/up";
    }

    @PostMapping("/sign/up")
    public void createUser(User user, Model model) {
        if (userService.addUser(user)) {
            model.addAttribute(messageText, "User was successfully created!");
            model.addAttribute(styleDisplayMessage, "display: flex; align-items: center; background-color: #04ff008c");
        } else {
            model.addAttribute(styleDisplayMessage, "display: flex; align-items: center; background-color: #ff00008c");
            model.addAttribute(messageText, ("User with email: " + user.getEmail() + ", already exists!"));
        }
    }
}