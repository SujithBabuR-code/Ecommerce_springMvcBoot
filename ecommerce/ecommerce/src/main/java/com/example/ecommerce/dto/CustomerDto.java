package com.example.ecommerce.dto;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class CustomerDto {
	@Id
	@GeneratedValue(generator = "customer_id")
	@SequenceGenerator(name = "customer_id",initialValue = 111001,allocationSize = 1,sequenceName = "customer_id")
	private int id;
	@Size(min = 5,message = "enter more than 4 character")
	private String name;
	@Email(message = "Email is Not correct format")
	private String email;
	@Size(max = 10,message = "mobile number should be 10")
	private long mobile;
	private String password;
	private String gender;
	private LocalDate dob;
}
