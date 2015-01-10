package pl.dmcs.nsai.struts2.repositories;

import org.springframework.data.repository.CrudRepository;

import pl.dmcs.nsai.struts2.entities.ParkingData;

public interface ParkingDAO extends CrudRepository<ParkingData, Integer> {
	
}
