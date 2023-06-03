package com.example.onlineshop.controllers;

import com.example.onlineshop.message.request.LoginRequest;
import com.example.onlineshop.service.WorkerService;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/auth/")
@CrossOrigin(value = "http://localhost:3000")
public class AuthController {
    private final WorkerService workerService;

    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok().body(new Gson().toJson(workerService.login(loginRequest)));
    }
}
