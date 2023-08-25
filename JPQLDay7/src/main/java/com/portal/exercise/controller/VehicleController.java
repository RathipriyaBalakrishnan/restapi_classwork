package com.portal.exercise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.portal.exercise.model.VehicleModel;
import com.portal.exercise.service.VehicleService;

@RestController
public class VehicleController {
	
	@Autowired
	public VehicleService vserv;
	
	//get mapping
	 @GetMapping("/getVehicle")
	 public List<VehicleModel>getVehicleInfo()
	 {
	 return vserv.getVehicle();
	 }
	
	@PutMapping("/updateRows")
	public VehicleModel updateVehicleInfo(@RequestBody VehicleModel ha)
	{
		return vserv.updateVehicle(ha);
	}
	
	 
	 @GetMapping("/getAllRows")
	 public List<VehicleModel> getAllRows()
	 {
		 return vserv.getAllrows();
	 }
	 
	 
	//get specific data
	@GetMapping("/getSpecific/{type}/{name}")
	public List<VehicleModel> getSpec(@PathVariable ("type") String type,@PathVariable("name") String name)
	{
		return vserv.getSpecrows(type, name);
	}
	
	
	@GetMapping("/getSpecificrowbyjql/{type}")
	public List<VehicleModel> getSpecRow(@PathVariable ("type") String type)
	{
		return vserv.getSpecrowsJql(type);
	}
	
	
	//delete
	@DeleteMapping("/deleteRow/{id}")
	public String deleteRow(@PathVariable("id") int id) {
	return vserv.deleteRowByid(id)+" id deleted";
	}
	
	//update
	@PutMapping("/updateId/{type}/{id}")
	public String updateInfo(@PathVariable("type") String vehicletype,@PathVariable("id") int id)
	{
	return vserv.updateRow(vehicletype, id)+" rows are updated";
	}
	
	//delete
		@DeleteMapping("/deleteRowbyjpql/{id}")
		public String deleteRowJpql(@PathVariable("id") int id) {
		return vserv.deleteRowByIdJpql(id)+" id deleted";
		}
		

}

