package com.paypal.bfs.test.employeeserv.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;






@Entity
public class Address {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	public Address() {};

	public Address(int id, @NotBlank(message = "Please enter line 1") @Valid String line1, @Valid String line2,
			@NotBlank(message = "Please enter line 2") @Valid String city,
			@NotBlank(message = "Please enter the state") @Valid String state,
			@NotBlank(message = "Please enter the country") @Valid String country,
			@NotBlank(message = "Please enter the zip code") @Valid String zipCode) {
		super();
		this.id = id;
		this.line1 = line1;
		this.line2 = line2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
	}

	@Column(name = "line1")
	@NotBlank(message = "Please enter line 1")
	@Valid
	private String line1;

	@Column(name = "line2")
	@Valid
	private String line2;

	@Column(name = "city")
	@NotBlank(message = "Please enter line 2")
	@Valid
	private String city;

	@Column(name = "state")
	@NotBlank(message = "Please enter the state")
	@Valid
	private String state;
	
	@Column(name = "country")
	@NotBlank(message = "Please enter the country")
	@Valid
	private String country;

	@Column(name = "zip_code")
	@NotBlank(message = "Please enter the zip code")
	@Valid
	private String zipCode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	
}