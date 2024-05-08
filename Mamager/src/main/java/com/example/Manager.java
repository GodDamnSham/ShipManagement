package com.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="manager")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manager {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ID;
	@Column(name = "manager_name")
	private String name;
	
	
}
