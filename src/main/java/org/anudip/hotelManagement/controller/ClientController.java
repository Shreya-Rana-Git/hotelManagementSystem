package org.anudip.hotelManagement.controller;

import java.util.List;

import org.anudip.hotelManagement.bean.Client;
import org.anudip.hotelManagement.exception.ResourceNotFound;
import org.anudip.hotelManagement.repo.ClientRepository;
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
public class ClientController {
	
	@Autowired
	private ClientRepository repository;
	
	// get all clients
	@GetMapping("/clients")
	public List<Client> getClientList(){
		return repository.findAll();
	}
	
	// get by  client by id
	@GetMapping("/clients/{id}")
	public Client getClientById(@PathVariable Integer id) {
		return repository.findById(id).orElseThrow(()-> new ResourceNotFound("not found"));
	}
	
	//generate id
	@GetMapping("/clients/client-id-gen")
	public Integer generateId() {
		Integer maxId= repository.getMaxId();
		if(maxId==null)
			return 1001;
		else
			return ++maxId;
	}
	
	//save new client records
	@PostMapping("/clients")
	public void saveClient(@RequestBody Client client) {
		repository.save(client);
	}
	
	//delete client
	@DeleteMapping("/clients/{id}")
	public void deleteClient(@PathVariable Integer id) {
		Client client = repository.findById(id).orElseThrow(()-> new ResourceNotFound("not found"));
		repository.delete(client);
	}
	
	//update client
	@PutMapping("/clients/{id}")
	public void updateClient(@PathVariable Integer id,@RequestBody Client clientdata) {
		Client client = repository.findById(id).orElseThrow(()-> new ResourceNotFound("not found"));
		client.setAccommodationId(clientdata.getAccommodationId());
		client.setCheckinDate(clientdata.getCheckinDate());
		client.setCheckoutDate(clientdata.getCheckoutDate());
		client.setClientAddress(clientdata.getClientAddress());
		client.setClientName(clientdata.getClientName());
		client.setContactNo(clientdata.getContactNo());
		client.setGender(clientdata.getGender());
		client.setHotelId(clientdata.getHotelId());
		client.setPayStatus(clientdata.getPayStatus());
		repository.save(client);
	}

}
