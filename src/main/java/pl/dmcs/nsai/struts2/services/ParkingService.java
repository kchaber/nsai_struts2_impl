package pl.dmcs.nsai.struts2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dmcs.nsai.struts2.entities.ParkingData;
import pl.dmcs.nsai.struts2.repositories.ParkingDAO;

@Service
public class ParkingService {
	
	@Autowired
	private ParkingDAO parkingDAO;
	
	public ParkingService() {
		System.out.println("PARKING CREATED");
	}

	public ParkingData create(ParkingData entity) {
		parkingDAO.save(entity);
		return entity;
	}

	public void delete(ParkingData entity) {
		parkingDAO.delete(entity);
	}
}
