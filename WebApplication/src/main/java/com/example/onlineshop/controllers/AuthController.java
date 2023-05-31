package com.example.onlineshop.controllers;

import com.example.onlineshop.message.request.LoginRequest;
import com.example.onlineshop.service.WorkerService;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/auth/")
public class AuthController {
    private final WorkerService workerService;

    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest){
        String jwtToken = workerService.login(loginRequest);
        return ResponseEntity.status(HttpStatus.OK).body(jwtToken);
    }
}
