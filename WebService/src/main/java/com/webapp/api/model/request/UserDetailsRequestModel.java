package com.webapp.api.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailsRequestModel {
	@NotNull (message = "First name cannot be null")
	@Size(min=2, message="Name size too small")
	private String firstName;
	@NotNull (message = "First name cannot be null")
	private String lastName;
	@NotNull (message = "Email cannot be null")
	@Email
	private String email;
	@NotNull (message= "Password cannot be null")
	@Size(min=8,max=16, message="Password must be greater than equal to 8 and less than equal to 16 characters")
	private String password;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
