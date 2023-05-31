package com.example.onlineshop.controllers;

import com.example.onlineshop.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/manager/")
@PreAuthorize("hasAuthority('MANAGER')")
public class ManagerController {

    private final ManagerService managerService;

    @GetMapping(value = "/allProducts")
    public ResponseEntity<String> allProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(managerService.findAllProducts());
    }

    @GetMapping(value = "/allCategories")
    public ResponseEntity<String> allCategories(){
        return ResponseEntity.status(HttpStatus.OK).body(managerService.findAllCategories());
    }
}
