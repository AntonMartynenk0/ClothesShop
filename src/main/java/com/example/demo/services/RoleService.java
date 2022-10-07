package com.example.demo.services;

import com.example.demo.entities.Role;
import com.example.demo.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService {

    private final RoleRepository repository;

    @Autowired
    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    public List<Role> getAll(){

        return repository.findAll()
                .stream().filter(role -> role.getId() != 1)
                .collect(Collectors.toList());
    }

    public Role getById(long id){

        return repository.findById(id).orElse(null);
    }

    public Role getByName(String name){

        return repository.findByName(name).stream().findFirst().orElse(null);
    }
}
