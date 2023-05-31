package com.example.onlineshop.dataBases.PostgreSQL.Entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority{
    ADMIN,
    MANAGER;

    @Override
    public String getAuthority() {
        return name();
    }
}
