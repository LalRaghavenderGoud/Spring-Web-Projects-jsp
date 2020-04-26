package com.raghav.springweb.dao;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.raghav.springweb.validations.ValidEmail;

public class User {

	@NotBlank(message="User name can't be blank.")
	@Size(min=5 , max=15)
	@Pattern(regexp = "^\\w{5,}$" )
	private String username;
	@NotBlank()
	@Size(min=4,max=15,message="Password between 4-15 Characters")
	@Pattern(regexp="^\\S+$" , message="password should not contain space")
	private String password;
	@ValidEmail()
	private String email;
	private boolean enabled = false;
	private String authority;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, String email, boolean enabled, String authority) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.enabled = enabled;
		this.authority = authority;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
