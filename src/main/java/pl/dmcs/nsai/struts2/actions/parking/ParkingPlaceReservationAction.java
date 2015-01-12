package pl.dmcs.nsai.struts2.actions.parking;

import java.util.HashSet;
import java.util.Set;

import org.springframework.util.StringUtils;

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
	
	private String selectedParkingPlaceIndexesString;
	private Set<ParkingPlaceData> selectedParkingPlaces;
	
	public static final String SELECTED_LIST_AJAX = "selectedListAjax";
	
	@Override
	public ParkingPlaceReservationData loadManagedEntity(Integer id) {
		return null;
	}

	@Override
	protected void reset() {
		super.reset();
		this.managedEntity = new ParkingPlaceReservationData();
		this.setSelectedParkingPlaceIndexesString(null);
	}
	
	public String input() {
		super.input();
		
		this.listReserved();
		
		return INPUT;
	}
	
	public String listReserved() {
		this.setSelectedParkingPlaceIndexesString(null);
		this.reservedPlaces = this.parkingPlaceService.findByBookingDateAndParkingId(this.getParkingPlaceReservationData().getBookingDate(), this.getParkingData().getId());
		
		return SUCCESS;
	}
	
	public String ajaxListSelected() {
		//when the action is called, than selectedParkingPlaceIds is populated automatically
		return SELECTED_LIST_AJAX;
	}
	
	public String save() {
		if (this.selectedParkingPlaces.isEmpty()) {
			this.addActionError(this.getText("actionErrors.noParkingPlaceSelected"));
			return INPUT;
		}
		
		for (ParkingPlaceData parkingPlace : this.selectedParkingPlaces) {
			this.parkingPlaceService.createReservation(this.getLoggedUser(), parkingPlace, this.managedEntity.getBookingDate());
		}
		
		this.setSelectedParkingPlaceIndexesString(null);
		//reload reserved parking places
		this.listReserved();
		
		this.addActionMessage(getText("actionMessages.operationSuccessful"));
		
		return SUCCESS;
	}
	
	@Override
	public void removeManagedEntity(Integer id) {

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

	public String getSelectedParkingPlaceIndexesString() {
		return selectedParkingPlaceIndexesString;
	}
	
	public void setSelectedParkingPlaceIndexesString(String selectedParkingPlaceIndexesString) {
		this.selectedParkingPlaces = new HashSet<>();
		this.selectedParkingPlaceIndexesString = selectedParkingPlaceIndexesString;
		if (!StringUtils.isEmpty(this.selectedParkingPlaceIndexesString)) {
			String[] splittedIndexes = this.selectedParkingPlaceIndexesString.split(",");
			for (String parkingPlaceStringIndex : splittedIndexes) {
				ParkingPlaceData ppd = this.parkingData.getPlaces().get(Integer.valueOf(parkingPlaceStringIndex));
				this.selectedParkingPlaces.add(ppd);
			}
		}
	}

	public Set<ParkingPlaceData> getSelectedParkingPlaces() {
		return selectedParkingPlaces;
	}

	public void setSelectedParkingPlaces(Set<ParkingPlaceData> selectedParkingPlaces) {
		this.selectedParkingPlaces = selectedParkingPlaces;
	}
}
