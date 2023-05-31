package com.example.onlineshop.service;

import com.example.onlineshop.dataBases.dao.CategoryDao;
import com.example.onlineshop.dataBases.dao.ProductDao;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManagerService {

    private final ProductDao productDao;

    private final CategoryDao categoryDao;
    public String findAllProducts() {
        return new Gson().toJson(productDao.findAll());
    }

    public String findAllCategories() {
        return new Gson().toJson(categoryDao.findAll());
    }
}
