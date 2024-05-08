package com.example.products;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("MANAGER")
public interface FeignClientService {

    @GetMapping ("/managers/{id}")
    ResponseEntity<ManagerDTO> getManager(@PathVariable("id") Long id);

}
