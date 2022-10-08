package com.example.demo.services;

import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.NoSuchElementException;


@Service
public class UserService {
    private final UserRepository repository;
    private final RoleService roleService;

    public UserService(UserRepository repository, RoleService roleService) {
        this.repository = repository;
        this.roleService = roleService;
    }

    public boolean addUser(String name, String surname, String email, String phone, String password, String roleName) {
        boolean isSuccessful = false;
        boolean isAlreadyExists;
        try {
            isAlreadyExists = repository.findByEmailAndPhone(email, phone).stream().findFirst().get() != null;
        } catch (NullPointerException | NoSuchElementException e) {
            isAlreadyExists = false;
        }
        boolean isAdmin = roleName.equals("Admin");

        if (!isAdmin && !isAlreadyExists) {
            Role role = roleService.getByName(roleName);
            User user = new User(name, surname, email, phone, password, new Date(new java.util.Date().getTime()), role);
            repository.save(user);
            isSuccessful = true;
        }
        return isSuccessful;
    }
}
