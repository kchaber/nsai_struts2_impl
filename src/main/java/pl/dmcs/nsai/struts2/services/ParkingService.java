package pl.dmcs.nsai.struts2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dmcs.nsai.struts2.entities.ParkingData;
import pl.dmcs.nsai.struts2.repositories.ParkingDAO;
import pl.dmcs.nsai.struts2.utils.CollectionUtil;

@Service
public class ParkingService {

	@Autowired
	private ParkingDAO parkingDAO;

	public ParkingData save(ParkingData entity) {
		entity = parkingDAO.save(entity);
		return entity;
	}

	public void delete(ParkingData entity) {
		parkingDAO.delete(entity);
	}

	public List<ParkingData> findAll() {
		return CollectionUtil.iterableToList(this.parkingDAO.findAll());
	}
	
	public ParkingData findById(Integer id) {
		return this.parkingDAO.findOne(id);
	}
}
