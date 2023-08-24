package com.portal.exercise.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.exercise.model.VehicleModel;

public interface VehicleRepo extends  JpaRepository<VehicleModel, Integer>{

}
