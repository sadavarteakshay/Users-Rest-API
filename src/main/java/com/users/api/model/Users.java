package com.users.api.model;


 

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
 


@Entity
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "Name is mandatory")
	private String firstName;
	
	private String lastName;
	
	@NotBlank(message = "Email is mandatory")
	@Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
	private String email;
	
	@NotBlank(message = "Mobile is mandatory")
	@Size(min=10, max=15, message = "Mobile number should be min 10 or max 15 digits")
	private String mobile;
	
	private String address;
	
	private String city;
	
	private String state; 
	
	@Size(min=5, max=10, message = "Pincode should be min 5 or max 10 digits")
	private String pincode; 
	
	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private LocalDateTime created_on;
	
	
	@UpdateTimestamp
	private LocalDateTime last_modified_on;
	
	private int version;
	
	
	

	public Users() {
		super();
		 
	}

	public Users(Long id, String firstName, String lastName, String email, String mobile, String address, String city,
			String state, String pincode, int version) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.version = version;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	
	public LocalDateTime getCreated_on() {
		return created_on;
	}

	public void setCreated_on(LocalDateTime created_on) {
		this.created_on = created_on;
	}

	public LocalDateTime getLast_modified_on() {
		return last_modified_on;
	}

	public void setLast_modified_on(LocalDateTime last_modified_on) {
		this.last_modified_on = last_modified_on;
	}

	
	
}
