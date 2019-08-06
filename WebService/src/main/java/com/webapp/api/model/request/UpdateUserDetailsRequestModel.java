package com.webapp.api.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {
	@NotNull (message = "First name cannot be null")
	@Size(min=2, message="First Name size too small")
	private String firstName;
	@NotNull (message = "Last name cannot be null")
	@Size(min=2, message="Last Name size too small")
	private String lastName;

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
}
