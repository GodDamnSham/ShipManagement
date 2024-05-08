package com.example.products;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    ProductRepo productRepo;

    public ProductService(ProductRepo productRepo){
        this.productRepo = productRepo;
    }

    public List<Product> getAllProducts(){
        return this.productRepo.findAll();
    }

    public Product getProductById(Long id){
        return this.productRepo.findById(id).orElse(null);
    }

    public Product addProduct(Product product){
        return this.productRepo.save(product);
    }

    public void delProductById(Long id){
        this.productRepo.deleteById(id);
    }

}
