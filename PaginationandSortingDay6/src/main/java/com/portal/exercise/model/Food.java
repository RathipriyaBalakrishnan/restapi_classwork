package com.portal.exercise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Food {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int foodId;
	private int cateringServiceId;
	private String foodName;
	private String foodType;
	private double price;
	private boolean available;
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public int getCateringServiceId() {
		return cateringServiceId;
	}
	public void setCateringServiceId(int cateringServiceId) {
		this.cateringServiceId = cateringServiceId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	
	
	
	
	
	

}
