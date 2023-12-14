package org.anudip.hotelManagement.repo;

import org.anudip.hotelManagement.bean.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ServicesRepository extends JpaRepository<Services,Integer> {
	@Query("select max(serviceId) from Services")
	public Integer getMaxSerialNo();
	
	@Query("select s from Services s where serviceName=?1")
	public Services getServiceByName(String serviceName);

}
