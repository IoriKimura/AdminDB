package com.example.adminka3.DataBases.MongoDB.Repository;

import com.example.adminka3.DataBases.MongoDB.Models.Category;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepo extends MongoRepository<Category, ObjectId> {

    Category findCategoryByCategoryName(String categoryName);
}
