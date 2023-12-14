package org.anudip.hotelManagement.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Hotel implements Comparable<Hotel>{
	//member data
	@Id
	private String hotelId;
	@Column(unique = true)
	private String hotelName;
	
	//constructor
	
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Hotel(String hotelName) {
		super();
		this.hotelName = hotelName;
	}



	public Hotel(String hotelId, String hotelName) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
	}
	
	
	//getter and setter methods 
	public String getHotelId() {
		return hotelId;
	}



	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}



	public String getHotelName() {
		return hotelName;
	}



	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}



	@Override
	public int compareTo(Hotel o) {
		// TODO Auto-generated method stub
		if(Integer.parseInt(this.hotelId.substring(1))>Integer.parseInt(o.hotelId.substring(1))) {
			return 1;
		}
		else if (Integer.parseInt(this.hotelId.substring(1))<Integer.parseInt(o.hotelId.substring(1))) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
	
	
	

}
