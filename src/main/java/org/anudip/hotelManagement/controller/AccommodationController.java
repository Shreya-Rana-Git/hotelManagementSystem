package org.anudip.hotelManagement.controller;

import java.util.List;

import org.anudip.hotelManagement.bean.Accommodation;
import org.anudip.hotelManagement.exception.ResourceNotFound;
import org.anudip.hotelManagement.repo.AccommodationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/hotel-app/")
public class AccommodationController {
	
	@Autowired
	private AccommodationRepository repository;
	
	
	// get all accommodation List
	@GetMapping("/accommodations")
	public List<Accommodation> getAllAccommodations(){
		return repository.findAll();
	}
	
	
	//get accommodation by id
	@GetMapping("/accommodations/{id}")
	public Accommodation getById(@PathVariable String id) {
		return repository.findById(id).orElseThrow(()->new ResourceNotFound("does not exist"));
	}
	
	
	//save new accommodation
	@PostMapping("/accommodations")
	public void saveAccommodation(@RequestBody Accommodation accommodation) {
		repository.save(accommodation);
	}
	
	//update accommodation data
	@PutMapping("/accommodations/{id}")
	public void UpdateAccommodation(@PathVariable String id, @RequestBody Accommodation accommodationData) {
		Accommodation accommodation = repository.findById(id).orElseThrow(()->new ResourceNotFound("does not exist"));
		accommodation.setFarePerDay(accommodationData.getFarePerDay());
		repository.save(accommodation);
	}
	
	
	//delete accommodation
	@DeleteMapping("/accommodations/{id}")
	public void deleteAccommodation(@PathVariable String id) {
		Accommodation accommodation = repository.findById(id).orElseThrow(()->new ResourceNotFound("does not exist"));
		repository.delete(accommodation);
	}
	

}
