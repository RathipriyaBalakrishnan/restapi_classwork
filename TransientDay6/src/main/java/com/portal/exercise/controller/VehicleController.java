package com.portal.exercise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.portal.exercise.model.VehicleModel;
import com.portal.exercise.service.VehicleService;

@RestController
public class VehicleController {
	
	@Autowired
	public VehicleService vserv;
	
	
	@PostMapping("/postVehicle")
	public String postVehicle(@RequestBody VehicleModel vr)
	{
		vserv.saveVehicle(vr);
		return "Data saved";
	}
	
	@GetMapping("/getVehicle")
	public List<VehicleModel> getHotelInfo()
	{
		return vserv.getVehicle();
	}
	
	
	

}
