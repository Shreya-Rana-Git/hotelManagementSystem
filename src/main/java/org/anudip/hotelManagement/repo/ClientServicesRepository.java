package org.anudip.hotelManagement.repo;

import java.util.List;

import org.anudip.hotelManagement.bean.ClientServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientServicesRepository extends JpaRepository<ClientServices, Integer> {
	@Query("select max(serialNumber) from ClientServices")
	public Integer getMaxSerialNo();
	@Query("select cs from ClientServices cs where clientNumber=?1")
	public List<ClientServices> getClientServicesByClientNumber( Integer clientId);

}
