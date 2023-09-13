package com.example.ecommerce.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class AdminDto {
	@Id
	@GeneratedValue(generator = "admin_id")
	@SequenceGenerator(name = "admin_id", initialValue = 211001, allocationSize = 1, sequenceName = "admin_id")
	private int id;
	@Size(min = 5, message = "*enter more than 4 character")
	private String name;
	@Email
	private String email;
	@Size(min = 8, message = "*Minimum 8 character")
	private String password;
	private int otp;

}
