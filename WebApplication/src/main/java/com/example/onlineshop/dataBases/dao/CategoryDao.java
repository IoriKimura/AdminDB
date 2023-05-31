package com.example.onlineshop.dataBases.dao;

import com.example.onlineshop.dataBases.MongoDB.entity.CategoryEntity;
import com.example.onlineshop.dataBases.MongoDB.repository.CategoryRepo;
import com.example.onlineshop.message.request.CategoryRequest;
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

    public void add(CategoryRequest request) {
        categoryRepo.save(CategoryEntity.builder().categoryName(request.getName()).build());
    }

    public boolean isCategoryExist(String categoryName){
        if (categoryRepo.findByCategoryName(categoryName).isPresent())
            return true;
        else
            return false;
    }
}
