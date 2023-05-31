package com.example.onlineshop.dataBases.MongoDB.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document(collection = "products")
@Getter
@Setter
public class ProductEntity {

    @MongoId
    @Field(name = "_id")
    private ObjectId productId;

    @Field(name = "amount")
    private int amount;

    @Field(name = "manufacturer")
    private String manufacturer;

    @Field(name = "price")
    private int price;

    @Field(name = "category")
    private ObjectId categoryId;

    @Field(name = "productName")
    private String productName;
}
