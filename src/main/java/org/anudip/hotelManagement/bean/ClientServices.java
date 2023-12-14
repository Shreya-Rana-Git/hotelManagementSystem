package org.anudip.hotelManagement.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ClientServices {
	//member data
	@Id
	private Integer serialNumber;
	private Integer clientNumber;
	private Integer serviceId;
	private String serviceType;
	private String date;
	private Double amount;
	
	//constructors
	public ClientServices() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClientServices(Integer clientNumber, String serviceType, String date, Double amount) {
		super();
		this.clientNumber = clientNumber;
		this.serviceType = serviceType;
		this.date = date;
		this.amount = amount;
	}

	

	public ClientServices(Integer serialNumber, Integer clientNumber, Integer serviceId, String serviceType,
			String date, Double amount) {
		super();
		this.serialNumber = serialNumber;
		this.clientNumber = clientNumber;
		this.serviceId = serviceId;
		this.serviceType = serviceType;
		this.date = date;
		this.amount = amount;
	}

	public ClientServices(Integer serialNumber, Integer clientNumber, String serviceType, String date, Double amount) {
		super();
		this.serialNumber = serialNumber;
		this.clientNumber = clientNumber;
		this.serviceType = serviceType;
		this.date = date;
		this.amount = amount;
	}
	
	
	//getter and setter methods
	public Integer getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Integer getClientNumber() {
		return clientNumber;
	}

	public void setClientNumber(Integer clientNumber) {
		this.clientNumber = clientNumber;
	}
	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
	

}
