package com.portal.exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.exercise.model.Food;

public interface FoodRepo extends JpaRepository<Food, Integer> {

}
