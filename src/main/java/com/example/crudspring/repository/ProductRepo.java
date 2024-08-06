package com.example.crudspring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.crudspring.model.Product;

public interface ProductRepo extends MongoRepository<Product, String>{
    
}
