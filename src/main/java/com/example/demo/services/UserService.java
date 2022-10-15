package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.entities.enums.Role;
import com.example.demo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public boolean addUser(User user) {
        if (!isUserAlreadyExists(user)) {
            user.setDateOfReg(new Date(new java.util.Date().getTime()));
            user.setRoles(Collections.singleton(Role.ROLE_USER));

            user.setPassword(passwordEncoder.encode(user.getPassword()));
            repository.save(user);
            return true;
        }
        return false;
    }

    public List<User> userList() {
        return repository.findAll();
    }

    private boolean isUserAlreadyExists(User user) {
        boolean isAlreadyExists;
        try {
            isAlreadyExists = repository.findByEmailAndPhone(user.getEmail(), user.getPhone()) != null;
        } catch (NullPointerException | NoSuchElementException e) {
            isAlreadyExists = false;
        }
        return isAlreadyExists;
    }
}
