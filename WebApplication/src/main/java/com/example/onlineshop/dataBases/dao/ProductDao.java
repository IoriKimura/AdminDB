package com.example.onlineshop.dataBases.dao;

import com.example.onlineshop.dataBases.MongoDB.entity.ProductEntity;
import com.example.onlineshop.dataBases.MongoDB.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductDao {

    private final ProductRepo productRepo;
    public List<ProductEntity> findAll() {
        return productRepo.findAll();
    }
}
