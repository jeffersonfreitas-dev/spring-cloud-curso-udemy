package com.example.demo.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserModel {

	@NotBlank(message = "Informe o primeiro nome")
	private String firstName;

	@NotBlank(message = "Informe o primeiro nome")
	private String lastName;
	
	private String password;
	
	@Email(message = "Informe um e-mail válido")
	private String email;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
