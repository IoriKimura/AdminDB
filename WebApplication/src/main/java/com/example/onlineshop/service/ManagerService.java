package com.example.onlineshop.service;

import com.example.onlineshop.dataBases.dao.ProductDao;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManagerService {

    private final ProductDao productDao;
    public String findAllProducts() {
        return new Gson().toJson(productDao.findAll());
    }
}
