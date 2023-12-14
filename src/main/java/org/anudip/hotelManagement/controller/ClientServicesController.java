package org.anudip.hotelManagement.controller;

import java.util.List;

import org.anudip.hotelManagement.bean.ClientServices;
import org.anudip.hotelManagement.bean.Services;
import org.anudip.hotelManagement.repo.ClientServicesRepository;
import org.anudip.hotelManagement.repo.ServicesRepository;
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
public class ClientServicesController {

	@Autowired
	private ClientServicesRepository repository;
	private ServicesRepository servicesRepository;
	
	//get client service list by clientid
	@GetMapping("/client-services/{id}")
	public List<ClientServices> getByClientId(@PathVariable Integer id){
	
		return repository.getClientServicesByClientNumber(id);
	}
	
	//generate serial number
	@GetMapping("/client-services/id-gen")
	public Integer generateSerialNumber() {
		Integer maxSerialId = repository.getMaxSerialNo();
		if (maxSerialId==null)
			return 1;
		else
			return ++maxSerialId;
	}
	
	//save new Client-Service
	@PostMapping("/client-services/{id}")
	public void saveClientServices(@PathVariable Integer id,@RequestBody ClientServices clientServices) {
		
		
		repository.save(clientServices);
	}
	
	//delete client services
	@DeleteMapping("/client-services/{id}")
	public void deleteClientServices(@PathVariable Integer id) {
		List<ClientServices> list = repository.getClientServicesByClientNumber(id);
		repository.deleteAll(list);
	}
	
	//delete single service
	@DeleteMapping("/client-service/{id}")
	public void deleteClientService(@PathVariable Integer id) {
		ClientServices clientService =  repository.findById(id).get();
		repository.delete(clientService);
	}
	
	
}
