package com.rajesh.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ProductTable")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private String brand;
	private BigDecimal price;
	private String category;
	
	private LocalDate releaseDate;
	private boolean productAvailable;
	private int stockQuantity;

	private String imageName;
	private String imageType;
	@Lob
	private byte[] imageData;
}
