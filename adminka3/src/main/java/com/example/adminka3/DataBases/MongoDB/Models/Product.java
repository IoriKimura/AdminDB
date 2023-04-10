package com.example.adminka3.DataBases.MongoDB.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @MongoId
    @Field(name = "_id")
    private ObjectId id;

    @Field(name = "amount")
    private int amount;

    @Field(name = "manufacturer")
    private String manufacturer;

    @Field(name = "price")
    private int price;

    @Field(name = "category")
    private ObjectId category;

    @Field(name = "productName")
    private String productName;

    public Product(int amount, String manufacturer, int price, ObjectId categoryID, String productName) {
        this.amount = amount;
        this.category = categoryID;
        this.productName = productName;
        this.price = price;
        this.manufacturer = manufacturer;
    }
}
