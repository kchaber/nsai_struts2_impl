package pl.dmcs.nsai.struts2.repositories;

import java.util.Date;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import pl.dmcs.nsai.struts2.entities.ParkingPlaceReservationData;

public interface ParkingPlaceReservationDAO extends CrudRepository<ParkingPlaceReservationData, Integer> {

	Set<ParkingPlaceReservationData> findByBookingDateAndParkingPlaceData_ParkingData_Id(Date bookingDate, Integer parkingDataId);

}
