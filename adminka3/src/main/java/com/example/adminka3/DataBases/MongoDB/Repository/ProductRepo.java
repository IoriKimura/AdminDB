package com.example.adminka3.DataBases.MongoDB.Repository;

import com.example.adminka3.DataBases.MongoDB.Models.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepo extends MongoRepository<Product, ObjectId> {
}
