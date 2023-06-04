package com.example.onlineshop.service;

import com.example.onlineshop.dataBases.dao.CategoryDao;
import com.example.onlineshop.dataBases.dao.ProductDao;
import com.example.onlineshop.message.request.CategoryRequest;
import com.example.onlineshop.message.request.ProductRequest;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManagerService {

    @Autowired
    private final ProductDao productDao;
    @Autowired
    private final CategoryDao categoryDao;
    public String findAllProducts() {
        return new Gson().toJson(productDao.findAll());
    }

    public String findAllCategories() {
        return new Gson().toJson(categoryDao.findAll());
    }

    public ResponseEntity<String> addNewCategory(CategoryRequest request) {
        if (categoryDao.isCategoryExist(request.getName()))
            return ResponseEntity.status(HttpStatus.FOUND).body("Такая категория уже существует");
        else {
            categoryDao.add(request);
            return ResponseEntity.ok().build();
        }
    }

    public ResponseEntity<String> addNewProduct(ProductRequest request) {
        if (productDao.isProductExist(request.getName()))
            return ResponseEntity.status(HttpStatus.FOUND).body("Товар уже существует");
        else{
            productDao.add(request);
            return ResponseEntity.ok().build();
        }
    }
}
