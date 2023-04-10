package com.example.adminka3.DataBases.MongoDB.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class newProductDTO {
    private String categoryName;
    private int amount;
    private String manufacturer;
    private int price;
    private String productName;
}
