package org.anudip.hotelManagement.repo;

import org.anudip.hotelManagement.bean.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, String>{

}
