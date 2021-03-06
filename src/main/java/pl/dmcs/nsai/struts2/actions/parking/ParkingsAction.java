package pl.dmcs.nsai.struts2.actions.parking;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import pl.dmcs.nsai.struts2.actions.AbstractCRUDAction;
import pl.dmcs.nsai.struts2.entities.ParkingData;
import pl.dmcs.nsai.struts2.services.ParkingPlaceService;
import pl.dmcs.nsai.struts2.services.ParkingService;

import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

public class ParkingsAction extends AbstractCRUDAction<ParkingData> {
	private static final long serialVersionUID = -6451550369473282420L;

	private ParkingService parkingService;
	private ParkingPlaceService parkingPlaceService;
	
	private List<ParkingData> parkingsList = new ArrayList<>();

	@Validations(
		requiredStrings = { 
			@RequiredStringValidator(fieldName = "parkingData.name", key = "${getRequiredFieldMessage(fieldName)}", shortCircuit = true), 
			@RequiredStringValidator(fieldName = "parkingData.streetName", key = "${getRequiredFieldMessage(fieldName)}", shortCircuit = true) 
		}, 
		requiredFields = {
			@RequiredFieldValidator(fieldName = "parkingData.capacity", key = "${getRequiredFieldMessage(fieldName)}", shortCircuit = true) 
		}, 
		intRangeFields = { 
			@IntRangeFieldValidator(fieldName = "parkingData.capacity", key = "${getFieldRangeExceededMessage(fieldName, min, max)}", min = "0", max = "40", shortCircuit = true)
		}
	)
	public String save() throws Exception {
		if (this.getLoggedUser() != null && ServletActionContext.getRequest().isUserInRole("ROLE_ADMIN")) {
			this.managedEntity = parkingService.save(this.managedEntity);

			this.addActionMessage(getText("actionMessages.operationSuccessful"));
		} else {
			this.addActionError(getText("errors.unsufficentPrivileges"));
			return INPUT;
		}
		
		return SUCCESS;
	}

	@Override
	public ParkingData loadManagedEntity(Integer id) {
		return this.parkingService.findById(id);
	}

	@Override
	protected void reset() {
		super.reset();
		this.managedEntity = new ParkingData();
	}

	@Override
	public String list() {
		this.parkingsList = this.parkingService.findAll();

		return LIST;
	}
	
	public String remove() {
		if (this.getLoggedUser() != null && ServletActionContext.getRequest().isUserInRole("ROLE_ADMIN")) {
			if (this.selectedId != null) {
				boolean anyActiveReservations = parkingPlaceService.isAnyActiveReservation(selectedId);
				System.out.println("A: " + anyActiveReservations);
				if (!anyActiveReservations) {
					this.removeManagedEntity(this.selectedId);
					this.addActionMessage(getText("actionMessages.successfulRemoval"));
				} else {
					this.addActionError(getText("actionError.cannotRemoveParkingWithActiveReservations"));
					return INPUT;
				}
			}
		} else {
			this.addActionError(getText("errors.unsufficentPrivileges"));
			return INPUT;
		}

		return this.list();
	}
	
	@Override
	public void removeManagedEntity(Integer id) {
		this.parkingService.remove(id);
	}

	public ParkingData getParkingData() {
		return this.managedEntity;
	}

	public void setParkingData(ParkingData parkingData) {
		this.managedEntity = parkingData;
	}

	public ParkingService getParkingService() {
		return parkingService;
	}

	public void setParkingService(ParkingService parkingService) {
		this.parkingService = parkingService;
	}

	public List<ParkingData> getParkingsList() {
		return parkingsList;
	}

	public void setParkingsList(List<ParkingData> parkingsList) {
		this.parkingsList = parkingsList;
	}

	public ParkingPlaceService getParkingPlaceService() {
		return parkingPlaceService;
	}

	public void setParkingPlaceService(ParkingPlaceService parkingPlaceService) {
		this.parkingPlaceService = parkingPlaceService;
	}
}
