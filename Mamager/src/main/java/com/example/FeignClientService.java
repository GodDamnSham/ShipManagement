package com.example;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("PRODUCTS")
public interface FeignClientService {

    @PostMapping("/products")
    ResponseEntity<productDTO> addProduct(@RequestBody productDTO product);

}
