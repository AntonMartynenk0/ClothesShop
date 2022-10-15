package com.example.demo.entities.enums;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Table(name = "user_role")
public enum Role implements GrantedAuthority {
    ROLE_USER, ROLE_ADMIN;
    @Getter
    @Setter
    @Column(name = "id", nullable = false)
    private Long id;

    @Override
    public String getAuthority() {
        return name();
    }
}
