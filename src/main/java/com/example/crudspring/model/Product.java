package com.example.crudspring.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="product")
public class Product {
    @Id
    private String id;
    private String productName;
    private int productPrice;
}
