package org.anudip.hotelManagement.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Services {
	//member data
	@Id
	private Integer serviceId;
	private String serviceName;
	private Double price;
	//constructors
	public Services() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Services(String serviceName, Double price) {
		super();
		this.serviceName = serviceName;
		this.price = price;
	}
	public Services(Integer serviceId, String serviceName, Double price) {
		super();
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.price = price;
	}
	
	//getter & setter methods
	
	public String getServiceName() {
		return serviceName;
	}
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	

}
