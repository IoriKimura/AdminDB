package com.example.onlineshop.controllers;

import com.example.onlineshop.message.request.RegistrationRequest;
import com.example.onlineshop.message.request.UpdateRequest;
import com.example.onlineshop.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping(value = "/api/admin/")
public class AdminController {

    private final AdminService adminService;

    @GetMapping(value = "/allUsers")
    public ResponseEntity<String> allUser(){
        return ResponseEntity.status(HttpStatus.OK).body(adminService.findAllUsers());
    }

    @PostMapping(value = "/delete/{key}")
    public ResponseEntity<String> deleteUser(@PathVariable Long key){
        return adminService.delete(key);
    }

    @PostMapping(value = "/registration")
    public ResponseEntity<String> registration(@RequestBody RegistrationRequest regRequest){
        if (adminService.register(regRequest))
            return ResponseEntity.status(HttpStatus.CREATED).build();
        else
            return ResponseEntity.status(HttpStatus.FOUND).body("Пользователь уже существует");
    }

    @PostMapping(value = "/update")
    public ResponseEntity<String> updateWorker(@RequestBody UpdateRequest updateRequest){
        return ResponseEntity.status(HttpStatus.OK).body(adminService.updateInfo(updateRequest));
    }
}
