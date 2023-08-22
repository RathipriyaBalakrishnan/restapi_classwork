package com.example.reference.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reference.model.HotelModel;
import com.example.reference.repository.HotelRepo;

@Service
public class HotelService {
	
	@Autowired
	public HotelRepo hrepo;
	
	
	//post the data
	public String saveHotel(HotelModel h)
	{
		hrepo.save(h);
		return "Data is saved to the database";
	}
	
	//get the data
	public List<HotelModel> getHotel()
	{
		return hrepo.findAll();
	}
	
	//getUserById
	public Optional<HotelModel> getUserId(int userId)
	{
		Optional<HotelModel> hotel = hrepo.findById(userId);
		if(hotel.isPresent()) {
			return hotel;
		}
		return null;
	}
	
	//update the data(put)
	public HotelModel updateHotel(HotelModel hm)
	{
		return hrepo.saveAndFlush(hm);
	}
	
	//update the data if id present
	public boolean updateHotelif(int hotelId,HotelModel hm)
	{
		if(hrepo.existsById(hotelId)) {
			hrepo.save(hm);
			return true;
		}
		return false;
	}
	
	
	//delete if id is present
	public boolean deleteHotelif(int hotelId)
	{
		if(hrepo.existsById(hotelId)) {
			hrepo.deleteById(hotelId);
			return true;
		}
		return false;
	}
	
	//delete the data
	public void deleteHotel(int hotel_id)
	{
		System.out.println("Deleted");
		hrepo.deleteById(hotel_id);
	}
	
}