package com.portal.exercise.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.portal.exercise.model.Food;
import com.portal.exercise.service.FoodService;

@RestController
public class FoodController {
	
	@Autowired
	public FoodService fserv;
	
	//post
	@PostMapping("/postFood")
	public String postFood(@RequestBody Food fm)
	{
		fserv.saveFood(fm);
		return "Date saved";
	}
	
	//get mapping
	@GetMapping("/getFood")
	public List<Food> getFoodInfo()
	{
		return fserv.getFood();
	}
	
	//getUserById
	@GetMapping("/users/{userId}")
	public ResponseEntity<?> getEventById(@PathVariable int userId)
	{
		Optional <Food> food = fserv.getFoodById(userId);
		if(food!= null)
		{
			return ResponseEntity.ok(food);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event not available with Id");
		}
	}
	
	//put mapping
	@PutMapping("/updateEvent")
	public Food updateEventInfo(@RequestBody Food ea)
	{
		return fserv.updateFood(ea);
	}
	
	//put mapping using path and request param
	@PutMapping("/updateEventif/{id}")
	public ResponseEntity<String> updateEventinfor(@PathVariable int id, @RequestBody Food ea)
	{
		boolean updated = fserv.updateFoodif(id, ea);
		if(updated)
		{
			return ResponseEntity.ok("Event with ID "+id+" is updated successfully");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event with ID "+id+" not found");
		}
	}
	
	//sorting by ascending
	@GetMapping("/sortAsc/{name}")
	public List<Food> sortasc(@PathVariable ("name")String foodName)
	{
		return fserv.sortByAsc(foodName);
	}
		
	//sorting by descending
	@GetMapping("/sortDes/{name}")
	public List<Food> sortdes(@PathVariable("name") String foodName)
	{
		return fserv.sortByDes(foodName);
	}
		
	//Pagination  
	   @GetMapping("/pagination/{num}/{size}")
	   public List<Food>paginationEx(@PathVariable("num")int num,@PathVariable("size")int size)
	   {
		   return fserv.pagination(num, size);
	   }
	   	   
	   
	//pagination and sorting  
		   @GetMapping("/paginationandsorting/{num}/{size}/{name}")
		   public List<Food>paginationEx1(@PathVariable("num")int num,@PathVariable("size")int size,@PathVariable("name")String foodName)
		   {
			   return fserv.paginationAndSorting(num, size,foodName);
		   }
		   	 

}
