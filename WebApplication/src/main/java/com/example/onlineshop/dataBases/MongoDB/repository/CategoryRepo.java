package com.example.onlineshop.dataBases.MongoDB.repository;

import com.example.onlineshop.dataBases.MongoDB.entity.CategoryEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepo extends MongoRepository<CategoryEntity, ObjectId> {

    Optional<CategoryEntity> findByCategoryName(String categoryName);
}
