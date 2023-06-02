package com.example.onlineshop.message.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private int amount;
    private String manufacturer;
    private int price;
    private ObjectId category;
    private String name;
}
