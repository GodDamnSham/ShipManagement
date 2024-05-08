package com.example.products;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "container_name")
    String containerName;
    @Column(name = "weight")
    Long containerWeight;
    @Column(name="managerID")
    Long createdBY;
}
