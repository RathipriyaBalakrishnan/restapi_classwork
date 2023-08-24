package com.portal.exercise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.portal.exercise.model.Food;
import com.portal.exercise.repository.FoodRepo;

@Service
public class FoodService {
	
	@Autowired FoodRepo frepo;
	
	//post the data
	public String saveFood(Food f)
	{
		frepo.save(f);
		return "Data is saved to the database";
	}
   
	
	//get the data
	public List<Food> getFood()
	{
		return frepo.findAll();
	}
	
	//getUserById
		public Optional<Food> getFoodById(int userId)
		{
			Optional<Food> food = frepo.findById(userId);
			if(food.isPresent()) {
				return food;
			}
			return null;
		}
		
		//update the data(put)
		public Food updateFood(Food em)
		{
			return frepo.saveAndFlush(em);
		}
		
		//update the data if id present
		public boolean updateFoodif(int eventId,Food em)
		{
			if(frepo.existsById(eventId)) {
				frepo.save(em);
				return true;
			}
			return false;
		}
	
		
		//sorting by ascending
	    public List<Food> sortByAsc(String foodName)
	    {
	    	return frepo.findAll(Sort.by(foodName).ascending());
	    }
	    
	    //sorting by descending
	    public List<Food> sortByDes(String foodName)
	    {
	    	return frepo.findAll(Sort.by(foodName).descending());
	    }
	   
	    //pagination
	    public List<Food>pagination(int pageNum,int pageSize)
	    {
	    	Page<Food>cont=frepo.findAll(PageRequest.of(pageNum,pageSize));
	    	return cont.getContent();
	    }

	    //pagination and sorting
	    public List<Food>paginationAndSorting(int pageNum,int pageSize,String name)
	    {
	    	Page<Food>cont1=frepo.findAll(PageRequest.of(pageNum,pageSize,Sort.by(name)));
	    	return cont1.getContent();
	    }
}
