package com.example.onlineshop.controllers;

import com.example.onlineshop.message.request.CategoryRequest;
import com.example.onlineshop.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/addCategory")
    public ResponseEntity<String> addCategory(@RequestBody CategoryRequest categoryRequest){
        return managerService.addNewCategory(categoryRequest);
    }
}
