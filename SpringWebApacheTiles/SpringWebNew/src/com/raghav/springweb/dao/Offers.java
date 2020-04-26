package com.raghav.springweb.dao;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.raghav.springweb.validations.ValidEmail;

public class Offers {

	private int id;

	@Size(min = 5,max=35, message="Name must be between 5 nad 3 characters")
	private String name;
	
	@NotNull
	//@Pattern(regexp=".*\\@.*\\..*",message = "Not a valid email address")
	@ValidEmail
	private String email;
	
	@Size(min=10, max=100,message="Text should be inbetween 10 and 100 characters")
	private String text;

	public Offers() {

	}

	public Offers(String name, String email, String text) {
		this.name = name;
		this.email = email;
		this.text = text;
	}

	public Offers(int id, String name, String email, String text) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Offers [id=" + id + ", name=" + name + ", email=" + email + ", text=" + text + "]";
	}

}
