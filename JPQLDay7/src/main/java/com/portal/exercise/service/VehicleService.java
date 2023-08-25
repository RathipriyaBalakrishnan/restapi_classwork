package com.portal.exercise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import com.portal.exercise.model.VehicleModel;
import com.portal.exercise.repository.VehicleRepo;


@Service
public class VehicleService {
	
	@Autowired
	public VehicleRepo vrepo;
	
	//get
	public List<VehicleModel>getVehicle()
	 {
	 return vrepo.findAll();
	 }
	
	//put
	public VehicleModel updateVehicle(VehicleModel hm)
	{
		return vrepo.saveAndFlush(hm);
	}
	
	//update the data
	public Integer updateRow(String type,int id)
	{
		return vrepo.updateByid(type, id);
	}
	
	//get
	public List <VehicleModel> getAllrows()
	{
		return vrepo.getAllRows();
	}
	
	
	//get specific rows
	public List<VehicleModel> getSpecrows(String type,String name)
	{
		return vrepo.getSpecRows(type,name);
	}
	
	//get specific rows by jql
	public List<VehicleModel> getSpecrowsJql(String type)
	{
		return vrepo.getSpecRowsByJql(type);
	}
	
	//delete the data
	 public int deleteRowByid(int id)
	 {
	 return vrepo.deleteId(id);
	 }
	 
	 public int deleteRowByIdJpql(int id)
	 {
		 return vrepo.deleteIdUsingJpa(id);
	 }
	 

}
