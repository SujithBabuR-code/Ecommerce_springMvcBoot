package com.example.ecommerce.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Component
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
	private long mobile;
	private String password;
	private String gender;
	@Past(message = "can Accept only past dates,not present or Future dates")
	private LocalDate dob;
}
