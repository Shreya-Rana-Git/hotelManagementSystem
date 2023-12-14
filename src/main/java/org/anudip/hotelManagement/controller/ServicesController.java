package org.anudip.hotelManagement.controller;

import java.util.List;

import org.anudip.hotelManagement.bean.Services;
import org.anudip.hotelManagement.exception.ResourceNotFound;
import org.anudip.hotelManagement.repo.ServicesRepository;
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
public class ServicesController {
	
	@Autowired
	private ServicesRepository repository;
	
	//get all services
	@GetMapping("/services")
	public List<Services> getAllServices(){
		return repository.findAll();
	}
	
	//generate id
	@GetMapping("/services/id-gen")
	public Integer generateId() {
		Integer maxId  = repository.getMaxSerialNo();
		Integer newId=0;
		if(maxId==null) {
			newId=1;
		}
		else {
			newId=++maxId;
		}
		return newId;
	}
	
	//save new Services
	@PostMapping("/services")
	public void saveNewService(@RequestBody Services serviceData) {
		/*Services service = new Services();
		service.setServiceId(this.generateId());
		service.setServiceName(serviceData.getServiceName());
		service.setPrice(serviceData.getPrice());*/
		repository.save(serviceData);
	
	}
	
	//Update Services
		@PutMapping("/services/{id}")
		public void updateService(@PathVariable Integer id,@RequestBody Services serviceData) {
			Services service = repository.findById(id).orElseThrow(()->new ResourceNotFound("not found"));
			service.setServiceName(serviceData.getServiceName());
			service.setPrice(serviceData.getPrice());
			repository.save(service);
		
		}
		
		//delete service
		@DeleteMapping("/services/{id}")
		public void deleteService(@PathVariable Integer id) {
			Services service = repository.findById(id).orElseThrow(()->new ResourceNotFound("not found"));
			repository.delete(service);
		}
		
		
		//get service by name
		@GetMapping("/services/{name}")
		public Services getServiceByName(@PathVariable String name) {
			return repository.getServiceByName(name);
		}

		//get service by id
				@GetMapping("/serviceById/{id}")
				public Services getServiceById(@PathVariable Integer id) {
					return repository.findById(id).get();
				}

}
