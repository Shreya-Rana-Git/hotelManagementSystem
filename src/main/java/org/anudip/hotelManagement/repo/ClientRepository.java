package org.anudip.hotelManagement.repo;

import org.anudip.hotelManagement.bean.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{

	@Query("select max(clientNumber) from Client")
	public Integer getMaxId();
	
}
