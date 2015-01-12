package pl.dmcs.nsai.struts2.actions.reservations;

import java.util.ArrayList;
import java.util.List;

import pl.dmcs.nsai.struts2.actions.AbstractCRUDAction;
import pl.dmcs.nsai.struts2.entities.ParkingPlaceReservationData;
import pl.dmcs.nsai.struts2.services.ParkingPlaceService;

public class UserReservationsAction extends AbstractCRUDAction<ParkingPlaceReservationData> {
	private static final long serialVersionUID = 4295614430520517707L;
	
	private ParkingPlaceService parkingPlaceService;
	
	private List<ParkingPlaceReservationData> activeReservations = new ArrayList<>();
	
	@Override
	public ParkingPlaceReservationData loadManagedEntity(Integer id) {
		return null;
	}

	@Override
	public String list() {
		this.activeReservations = this.parkingPlaceService.findActiveUserReservations(this.getLoggedUser().getId());
		
		return LIST;
	}
	
	@Override
	public void removeManagedEntity(Integer id) {
		this.parkingPlaceService.removeReservation(id);
	}

	public ParkingPlaceService getParkingPlaceService() {
		return parkingPlaceService;
	}

	public void setParkingPlaceService(ParkingPlaceService parkingPlaceService) {
		this.parkingPlaceService = parkingPlaceService;
	}

	public List<ParkingPlaceReservationData> getActiveReservations() {
		return activeReservations;
	}

	public void setActiveReservations(List<ParkingPlaceReservationData> activeReservations) {
		this.activeReservations = activeReservations;
	}
}
