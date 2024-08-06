package com.example.crudspring.services.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.crudspring.model.Product;
import com.example.crudspring.repository.ProductRepo;
import com.example.crudspring.services.ProductServices;

@Service
public class ProductServiceImpl implements ProductServices {
    

    private final ProductRepo productRepo;
     
    @Autowired
    public ProductServiceImpl(ProductRepo productRepo){
        this.productRepo = productRepo;
    }


    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
       return productRepo.save(product);
    }

  
   @Override
   public Page<Product> getProduct(int page, int size){
        PageRequest pageRequest = PageRequest.of(page, size);
        return productRepo.findAll(pageRequest);
   }
}
