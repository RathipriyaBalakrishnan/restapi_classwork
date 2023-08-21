package com.example.reference.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.reference.model.PetrolBunk;
import com.example.reference.repository.FuelRepo;

@Service
public class FuelService {
	
	
	@Autowired
	public FuelRepo frepo;
	
	//post the data
	public PetrolBunk saveDetails(PetrolBunk p)
	{
		return frepo.save(p);
	}
	
	
	//get the data
	public List <PetrolBunk> getDetails()
	{
		return frepo.findAll();
	}

}

