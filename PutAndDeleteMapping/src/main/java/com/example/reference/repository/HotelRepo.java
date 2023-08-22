package com.example.reference.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reference.model.HotelModel;

public interface HotelRepo extends JpaRepository<HotelModel, Integer>{

}
