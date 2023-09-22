package com.example.ecommerce.dto;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Component
public class ProductDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty(message = "*This is Required Field")
	private String name;

	@DecimalMin(value = "1", message = "*Enter Value Greater than 1")
	@NotNull(message = "*This is Required Field")
	private int stock;

	@DecimalMin(value = "1", message = "*Enter Value Greater than 1")
	@NotNull(message = "*This is Required Field")
	private double price;

	@NotEmpty(message = "*This is Required Field")
	private String category;

	boolean approved;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private byte[] picture;

}
