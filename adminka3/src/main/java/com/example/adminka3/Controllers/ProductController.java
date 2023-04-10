package com.example.adminka3.Controllers;

import com.example.adminka3.DataBases.MongoDB.DTOs.newProductDTO;
import com.example.adminka3.DataBases.MongoDB.Models.Product;
import com.example.adminka3.DataBases.MongoDB.Repository.CategoryRepo;
import com.example.adminka3.DataBases.MongoDB.Repository.ProductRepo;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//ToDo: Получение списка всех товаров
//ToDo: Добавление товара в БД
//ToDo: Удаление товара из БД

@RestController
@AllArgsConstructor
public class ProductController {
    @Autowired
    ProductRepo productRepo;
    @Autowired
    CategoryRepo categoryRepo;

    @GetMapping("api/allProducts")
    public List<Product> findAllProducts(){
        return productRepo.findAll();
    }

    @PostMapping("api/addProduct")
    public String addProduct(@RequestBody newProductDTO newDTO){
        ObjectId categoryID = categoryRepo.findCategoryByCategoryName(newDTO.getCategoryName()).getId();
        Product newProduct = new Product(newDTO.getAmount(), newDTO.getManufacturer(),
                newDTO.getPrice(), categoryID, newDTO.getProductName());
        try {
            productRepo.save(newProduct);
            return "Продукт добавлен в товары";
        } catch (Exception e) {
            return "Произошла ошибка, проверьте данные";
        }
    }

    @DeleteMapping("api/deleteProduct/{key}")
    public String deletingProduct(@PathVariable ObjectId key){
        Optional<Product> selectedProduct = productRepo.findById(key);
        if(selectedProduct.isEmpty())
            return "Такого товара нет, проверьте его идентификатор";
        else{
            productRepo.delete(selectedProduct.get());
            return "Продукт был успешно удалён";
        }
    }
}
