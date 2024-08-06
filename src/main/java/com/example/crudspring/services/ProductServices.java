package com.example.crudspring.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.crudspring.model.Product;

public interface ProductServices {
      public List<Product> getAllProducts();
      public Product saveProduct(Product product);
      Page<Product> getProduct(int page , int size);
}
