package pl.dmcs.nsai.struts2.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dmcs.nsai.struts2.entities.ParkingData;
import pl.dmcs.nsai.struts2.entities.ParkingPlaceData;
import pl.dmcs.nsai.struts2.repositories.ParkingDAO;
import pl.dmcs.nsai.struts2.utils.CollectionUtil;

@Service
public class ParkingService {

	@Autowired
	private ParkingDAO parkingDAO;
	
	public ParkingData save(ParkingData entity) {
		ParkingData oldParkingData = null;
		if (entity.getId() != null) {
			oldParkingData = this.findById(entity.getId());
		}
		
		if (entity.getAggregateBookedPlacesSize().compareTo(0) <= 0 && 
			((oldParkingData == null) || (oldParkingData != null && ObjectUtils.notEqual(oldParkingData.getCapacity(), entity.getCapacity())))) {
			this.generateParkingPlaces(entity);
		}
		
		entity = parkingDAO.save(entity);
		
		return entity;
	}
	
	private void generateParkingPlaces(ParkingData entity) {
		//remove all previous places
		entity.setPlaces(new ArrayList<ParkingPlaceData>());
		
		for (int i = 0; i < entity.getCapacity(); i++) {
			ParkingPlaceData parkingPlaceData = new ParkingPlaceData();
			parkingPlaceData.setOrderNum(i);
			entity.addPlace(parkingPlaceData);
		}
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
