package com.example.onlineshop.dataBases.MongoDB.entity;

import lombok.Builder;
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
@Builder
public class CategoryEntity {

    @MongoId
    @Field(name = "_id")
    private ObjectId categoryId;

    @Field(name = "categoryName")
    private String categoryName;
}
