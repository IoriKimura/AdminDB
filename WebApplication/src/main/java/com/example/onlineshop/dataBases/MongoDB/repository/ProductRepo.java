package com.example.onlineshop.dataBases.MongoDB.repository;

import com.example.onlineshop.dataBases.MongoDB.entity.ProductEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends MongoRepository<ProductEntity, ObjectId> {

    Optional<ProductEntity> findByProductName(String productName);
}
