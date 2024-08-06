package com.example.crudspring.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudspring.model.Product;
import com.example.crudspring.services.ProductServices;

@RestController
@RequestMapping("api/product")
public class ProductController {
      final ProductServices productServices;
    
    @Autowired
    public ProductController(ProductServices productServices){
       this.productServices = productServices;
    }
 
    @GetMapping("/all")
     public ResponseEntity<List<Product>> getAllProducts(){
     List<Product> product = productServices.getAllProducts(); 
     return ResponseEntity.ok(product);
    }

     @PostMapping
     public ResponseEntity<?> addProduct(@RequestBody Product product) {
        try {
            Product savedProduct = productServices.saveProduct(product);
            return ResponseEntity.ok(savedProduct);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

   @GetMapping
    public ResponseEntity<Page<Product>> getProduct(
            @RequestParam(defaultValue = "0") int page, 
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<Product> products = productServices.getProduct(page, size);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
