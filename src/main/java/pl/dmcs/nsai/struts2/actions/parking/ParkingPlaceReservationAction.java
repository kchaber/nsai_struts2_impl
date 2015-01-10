package pl.dmcs.nsai.struts2.actions.parking;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import pl.dmcs.nsai.struts2.actions.AbstractCRUDAction;
import pl.dmcs.nsai.struts2.entities.ParkingData;
import pl.dmcs.nsai.struts2.entities.ParkingPlaceData;
import pl.dmcs.nsai.struts2.entities.ParkingPlaceReservationData;
import pl.dmcs.nsai.struts2.services.ParkingPlaceService;
import pl.dmcs.nsai.struts2.services.ParkingService;

public class ParkingPlaceReservationAction extends AbstractCRUDAction<ParkingPlaceReservationData> {
	private static final long serialVersionUID = -4261691974313960632L;
	
	private ParkingService parkingService;
	private ParkingPlaceService parkingPlaceService;
	private ParkingData parkingData;
	
	private Set<ParkingPlaceReservationData> reservedPlaces = new HashSet<>();
	
	@Override
	public ParkingPlaceReservationData loadManagedEntity(Integer id) {
		return null;
	}

	@Override
	protected void reset() {
		super.reset();
		this.managedEntity = new ParkingPlaceReservationData();
	}
	
	public String input() {
		super.input();
		
		this.listReserved();
		
		return INPUT;
	}
	
	public String listReserved() {
		this.reservedPlaces = this.parkingPlaceService.findByBookingDateAndParkingId(this.getParkingPlaceReservationData().getBookingDate(), this.getParkingData().getId());
		
		return SUCCESS;
	}
	
	public String testCreate() {
		Random r = new Random();
		this.parkingPlaceService.createReservation(this.getLoggedUser(), parkingData.getPlaces().get(r.nextInt(parkingData.getPlaces().size())), this.managedEntity.getBookingDate());
		
		return SUCCESS;
	}
	
	public boolean isPlaceReserved(ParkingPlaceData parkingPlaceData) {
		ParkingPlaceReservationData compared = new ParkingPlaceReservationData();
		compared.setParkingPlaceData(parkingPlaceData);
		
		return this.reservedPlaces != null && this.reservedPlaces.contains(compared);
	}

	public ParkingPlaceReservationData getParkingPlaceReservationData() {
		return this.managedEntity;
	}

	public void setParkingPlaceReservationData(ParkingPlaceReservationData parkingPlaceReservationData) {
		this.managedEntity = parkingPlaceReservationData;
	}

	public ParkingService getParkingService() {
		return parkingService;
	}

	public void setParkingService(ParkingService parkingService) {
		this.parkingService = parkingService;
	}

	public ParkingPlaceService getParkingPlaceService() {
		return parkingPlaceService;
	}

	public void setParkingPlaceService(ParkingPlaceService parkingPlaceService) {
		this.parkingPlaceService = parkingPlaceService;
	}

	
	public Set<ParkingPlaceReservationData> getReservedPlaces() {
		return reservedPlaces;
	}

	public void setReservedPlaces(Set<ParkingPlaceReservationData> reservedPlaces) {
		this.reservedPlaces = reservedPlaces;
	}

	public ParkingData getParkingData() {
		return parkingData;
	}

	public void setParkingData(ParkingData parkingData) {
		this.parkingData = parkingData;
	}
}
