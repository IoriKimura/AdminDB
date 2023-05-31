package com.example.onlineshop.dataBases.MongoDB.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "category")
@Data
@Getter
@Setter
public class CategoryEntity {

    @MongoId
    @Field(name = "_id")
    private ObjectId categoryId;

    @Field(name = "categoryName")
    private String categoryName;
}
