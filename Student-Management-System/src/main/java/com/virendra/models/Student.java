package com.virendra.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	@NotNull(message = "First Name cannot be null!")
	@NotBlank(message = "First Name connot be blank!")
	private String FirstName;
	
	@NotNull(message = "Last Name cannot be null!")
	@NotBlank(message = "Last Name connot be blank!")
	private String LastName;
	
	private String Email;
	
	
	

}
