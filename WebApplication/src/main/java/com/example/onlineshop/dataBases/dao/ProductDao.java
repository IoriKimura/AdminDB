package com.example.onlineshop.dataBases.dao;

import com.example.onlineshop.dataBases.MongoDB.entity.CategoryEntity;
import com.example.onlineshop.dataBases.MongoDB.entity.ProductEntity;
import com.example.onlineshop.dataBases.MongoDB.repository.ProductRepo;
import com.example.onlineshop.message.request.ProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductDao {

    private final ProductRepo productRepo;
    public List<ProductEntity> findAll() {
        return productRepo.findAll();
    }

    public boolean isProductExist(String name) {
        if (productRepo.findByProductName(name).isPresent())
            return true;
        else
            return false;
    }

    public void add(ProductRequest request){
        productRepo.save(ProductEntity.builder()
                .productName(request.getName())
                .manufacturer(request.getManufacturer())
                .amount(request.getAmount())
                .price(request.getPrice())
                .categoryId(request.getCategory())
                .build());
    }
}
