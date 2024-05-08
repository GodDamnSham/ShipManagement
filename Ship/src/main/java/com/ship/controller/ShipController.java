package com.ship.controller;


import com.ship.entity.Ship;
import com.ship.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ship")
public class ShipController {

    @Autowired
    ShipService shipService;

    @GetMapping
    public ResponseEntity<List<Ship>> getAll (){
        List<Ship> s = this.shipService.getAllShips();
        if(s.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(s);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Ship>getById (@PathVariable("id") Long id){
        Ship s = this.shipService.getShipById(id);
        if(s==null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(s);
    }
    @PostMapping("/add")
    public ResponseEntity<Ship> addShip (@RequestBody Ship ship){
        if(ship.getShipName()==null||ship.getQuantity()==0||ship.getProductID()==0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Ship s = this.shipService.addShip(ship);
        if(s==null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(s);
    }
}
