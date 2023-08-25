package com.portal.exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.portal.exercise.model.VehicleModel;

import jakarta.transaction.Transactional;

import java.util.*;

public interface VehicleRepo extends JpaRepository<VehicleModel, Integer>{
	
	//native query
	@Query(value="select * from vehiclemodel",nativeQuery=true)
	public List<VehicleModel> getAllRows();


	@Query(value="select * from vehiclemodel where vehicletype=:type and vehiclename=:name",nativeQuery=true)
	public List<VehicleModel> getSpecRows(@Param("type")String vehicletype,@Param ("name") String vehiclename);
	
	//Delete using native query
	@Modifying
	@Transactional
	@Query(value="delete from vehiclemodel where id=:id",nativeQuery=true)
	public int deleteId(@Param("id")int id);
	
	
	
	//Update the native query
	@Modifying
	@Transactional
	@Query(value="update vehiclemodel set vehicletype=:name where id=:id",nativeQuery=true)
	public Integer updateByid(@Param("name") String name,@Param("id")int id);
	
	//JPQL query (gets specific rows)
	@Query("SELECT v FROM VehicleModel v WHERE v.vehicleType LIKE %?1%")
	public List<VehicleModel> getSpecRowsByJql(@Param("type") String vehicletype);
	

	//JPQL QUERY (delete by id )
	@Modifying
	@Transactional
	@Query("delete from VehicleModel v where v.vehicleId=:id")
	public int deleteIdUsingJpa(@Param("id") int id);
	
	
	
	
	
}
