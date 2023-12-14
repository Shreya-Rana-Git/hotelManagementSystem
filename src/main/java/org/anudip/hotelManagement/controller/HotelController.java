package org.anudip.hotelManagement.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.anudip.hotelManagement.bean.Hotel;
import org.anudip.hotelManagement.exception.ResourceNotFound;
import org.anudip.hotelManagement.repo.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/hotel-app/")
public class HotelController {

	@Autowired
	private HotelRepository repository;
	
	//get all hotels
	@GetMapping("/hotel")
	public List<Hotel> getAllHotels(){
		List<Hotel> hotelList = repository.findAll();
		Collections.sort(hotelList);
		return hotelList;
	}
	
	// get Hotel By Id
	@GetMapping("/hotel/{id}")
	public Hotel singleHotel(@PathVariable String id) {
		Hotel hotel= repository.findById(id).orElseThrow(()->
			new ResourceNotFound("does not exist")
		);
		return hotel;
	}
	
	// get the new id 
	@GetMapping("/hotel-id-gen")
	public String newHotelId() {
		List<Hotel> hotelList = repository.findAll();
		if(hotelList.isEmpty())
			return "H1";
		Collections.sort(hotelList);
		String lastId = hotelList.get(hotelList.size()-1).getHotelId();
		Integer num = Integer.parseInt(lastId.substring(1));
		num++;
		String newId = "H"+(num);
		return newId;
	}
	
	
	//save new hotel data
	@PostMapping("/hotel")
	public void saveHotel(@RequestBody Hotel hotel) {
		Hotel newHotel = hotel;
		newHotel.setHotelName("De Le Grande "+hotel.getHotelName());
		repository.save(newHotel);
	}
	
	
	
}
