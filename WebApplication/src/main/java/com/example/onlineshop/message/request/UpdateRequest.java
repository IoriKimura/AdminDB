package com.example.onlineshop.message.request;

import com.example.onlineshop.dataBases.PostgreSQL.Entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRequest {
    private Long userId;
    private String email;
    private String password;
    private String role;
}
