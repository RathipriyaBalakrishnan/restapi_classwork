package com.portal.exercise.model;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY )
	   @Column(name="uid")
	   private int  uid;
	   private String name;
	   private String email;
	   private String password;
	   
	   @OneToMany(cascade = CascadeType.ALL)
	   @JoinColumn(name="fk_uid",referencedColumnName = "uid")   
	  private List<Address> address;

	public int  getUid() {
		return uid;
	}

	public void setUid(int  uid) {
		this.uid = uid;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}
	   
	   

}
