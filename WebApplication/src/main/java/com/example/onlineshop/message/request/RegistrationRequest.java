package com.example.onlineshop.message.request;

import com.example.onlineshop.dataBases.PostgreSQL.Entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {
    private String name;
    private String surName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
}
