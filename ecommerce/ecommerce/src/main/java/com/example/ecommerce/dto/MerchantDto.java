package com.example.ecommerce.dto;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Entity
@Data
@Component
public class MerchantDto {
	@Id
	@GeneratedValue(generator = "merchant_id")
	@SequenceGenerator(name = "merchant_id", initialValue = 666001, allocationSize = 1, sequenceName = "merchant_id")
	private int id;
	@Size(min = 5, message = "enter more than 4 character")
	private String name;
	@Email(message = "Email is Not correct format")
	private String email;
	private long mobile;
	@Size(min = 8, message = "*Minimum 8 Character")
	private String password;
	@NotEmpty(message = "Select atleast One Gender")
	private String gender;
	@Past(message = "Date must not be today's or Future's Date")
	private LocalDate dob;
	private boolean status;
	private int otp;
	
	
	@OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	List<ProductDto> productDtos;

}
