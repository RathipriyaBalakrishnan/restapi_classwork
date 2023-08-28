package com.portal.exercise.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class StudentModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int stuId;
    private String stuName;
    
    @OneToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="address")
    private Address stuAddr;

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public Address getStuAddr() {
		return stuAddr;
	}

	public void setStuAddr(Address stuAddr) {
		this.stuAddr = stuAddr;
	}
	
    
}
