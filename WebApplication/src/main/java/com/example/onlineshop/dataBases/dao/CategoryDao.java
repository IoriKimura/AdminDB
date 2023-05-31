package com.example.onlineshop.dataBases.dao;

import com.example.onlineshop.dataBases.MongoDB.entity.CategoryEntity;
import com.example.onlineshop.dataBases.MongoDB.repository.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoryDao {

    private final CategoryRepo categoryRepo;
    public List<CategoryEntity> findAll() {
        return categoryRepo.findAll();
    }
}
