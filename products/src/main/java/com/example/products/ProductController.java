package com.example.products;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;
    FeignClientService fs;

    public ProductController(ProductService productService , FeignClientService fs){
        this.productService = productService;
        this.fs = fs;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> pl = this.productService.getAllProducts();
        if(pl.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pl);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductByID(@PathVariable("id") Long id){
        Product p = this.productService.getProductById(id);
        if(p==null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(p);
    }

    @GetMapping("/getProductManager/{id}")
    public ResponseEntity<ManagerDTO> getProductByManager(@PathVariable("id") Long id){
        Product p = this.productService.getProductById(id);
        ManagerDTO m = this.fs.getManager(p.getCreatedBY()).getBody();
        if(m==null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(m);
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        if(product.containerName ==null || product.containerWeight == 0){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        ManagerDTO m = this.fs.getManager(product.getCreatedBY()).getBody();
        if(Objects.equals(m, ResponseEntity.notFound())){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        Product p = this.productService.addProduct(product);
        if(p==null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(p);
    }

    @DeleteMapping("/{id}")
    public boolean deleteProductByID(@PathVariable("id") Long id){
        if(this.productService.getProductById(id) == null){
            return false;
        }
        this.productService.delProductById(id);
        return true;
    }




}

