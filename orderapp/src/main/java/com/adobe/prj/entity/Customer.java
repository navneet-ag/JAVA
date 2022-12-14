package com.adobe.prj.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class Customer {
	@Id
	private String email;
	
	@Column(name="first_name", length = 50, nullable = false)
	private String firstName;
	
	@Column(name="last_name", length = 50)
	private String lastName;
	
	@ManyToMany
	@JoinTable(
		        name="CUSTOMER_PRODUCTS",
		        joinColumns=
		            @JoinColumn(name="CUSTOMER_ID"),
		        inverseJoinColumns=
		            @JoinColumn(name="PRODUCT_ID")
		    )
	private List<Product> wishList = new ArrayList<>();

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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
