package com.portal.exercise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.portal.exercise.model.VehicleModel;
import com.portal.exercise.repo.VehicleRepo;

@Service
public class VehicleService {
	
	@Autowired
	public VehicleRepo vrepo;
	
	//post the data
	public String saveVehicle (VehicleModel v)
	{
		vrepo.save(v);
		return "Data is saved to database";
	}
	
	//get the data
	public List<VehicleModel> getVehicle()
	{
		return vrepo.findAll();
	}
	
	
	

}
