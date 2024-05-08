package com.ship.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SHIP")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long shipId;
    @Column(name = "Ship_name")
    String shipName;
    @Column(name = "Product_quantity")
    int quantity;
    @Column(name = "ProductID")
    Long productID;

}
