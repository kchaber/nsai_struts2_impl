package pl.dmcs.nsai.struts2.services;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import pl.dmcs.nsai.struts2.entities.ParkingPlaceData;
import pl.dmcs.nsai.struts2.entities.ParkingPlaceReservationData;
import pl.dmcs.nsai.struts2.entities.UserData;
import pl.dmcs.nsai.struts2.repositories.ParkingPlaceReservationDAO;
import pl.dmcs.nsai.struts2.utils.DateTimeUtil;

@Service
public class ParkingPlaceService {

	@Autowired
	private ParkingPlaceReservationDAO parkingPlaceReservationDAO;
	
	public ParkingPlaceReservationData createReservation(UserData userData, ParkingPlaceData parkingPlaceData, Date bookingDate) {
		ParkingPlaceReservationData parkingPlaceReservationData = new ParkingPlaceReservationData();
		parkingPlaceReservationData.setBookingDate(bookingDate);
		parkingPlaceReservationData.setUserData(userData);
		parkingPlaceReservationData.setParkingPlaceData(parkingPlaceData);
		
		parkingPlaceReservationData = this.parkingPlaceReservationDAO.save(parkingPlaceReservationData);
		return parkingPlaceReservationData;
	}
	
	public void removeReservation(Integer reservationId) {
		this.parkingPlaceReservationDAO.delete(reservationId);
	}
	
	public Set<ParkingPlaceReservationData> findByBookingDateAndParkingId(Date bookingDate, Integer parkingId) {
		Set<ParkingPlaceReservationData> result = this.parkingPlaceReservationDAO.findByBookingDateAndParkingPlaceData_ParkingData_Id(DateTimeUtil.removeTime(bookingDate), parkingId);
		return result;
	}
	
	public List<ParkingPlaceReservationData> findActiveUserReservations(Integer userId) {
		Sort sort = new Sort("bookingDate");
		List<ParkingPlaceReservationData> result = this.parkingPlaceReservationDAO.findByUserData_IdAndBookingDateGreaterThanEqual(userId, DateTimeUtil.getStartOfDay(DateTimeUtil.getCurrentDate()), sort);
		return result;
	}
	
	public boolean isAnyActiveReservation(Integer parkingId) {
		Long result = this.parkingPlaceReservationDAO.countByBookingDateGreaterThanEqualAndParkingPlaceData_ParkingData_Id(DateTimeUtil.removeTime(DateTimeUtil.getCurrentDate()), parkingId);
		System.out.println("COUNT: " + result);
		return result > 0;
	}
}
