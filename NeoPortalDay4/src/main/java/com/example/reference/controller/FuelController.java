package com.example.reference.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.reference.model.PetrolBunk;
import com.example.reference.service.FuelService;

@RestController
public class FuelController {
	
	
	@Autowired
	FuelService fser;
	//save data in the database
	
	@PostMapping("/saveFuel")
	public PetrolBunk saveFuelStationDe( @RequestBody  PetrolBunk pb)
	{
		return fser.saveDetails(pb);
	}
	
	
	@GetMapping("/getFuel")
	public List<PetrolBunk> getFuelStationDe()
	{		
		return fser.getDetails();
		
	}

	
}
