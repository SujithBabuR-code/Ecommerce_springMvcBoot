package com.example.ecommerce.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
	@Size(min = 5,message = "*enter more than 4 character")
	private String name;
	@NotEmpty
	@Email(message = "*Email is Not correct format")
	private String email;
	@DecimalMin(value = "6000000000",message =   "enter proper mobile Number")
	@DecimalMax(value = "10000000000",message = "enter proper mobile Number")
	@Digits(integer = 10,fraction = 0,message = "*enter 10 digit")
	private long mobile;
	@Size(min=8,message = "*Minimum 8 character")
	private String password;
	@NotEmpty(message = "*select Atleast one Gender")
	private String gender;
	@Past(message = "*Date must not be today's or Future's Date*")
	private LocalDate dob;
	private boolean status;
	private int otp;
}
