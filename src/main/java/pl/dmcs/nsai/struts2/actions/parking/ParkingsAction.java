package pl.dmcs.nsai.struts2.actions.parking;

import java.util.ArrayList;
import java.util.List;

import pl.dmcs.nsai.struts2.actions.AbstractCRUDAction;
import pl.dmcs.nsai.struts2.entities.ParkingData;
import pl.dmcs.nsai.struts2.services.ParkingService;

import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

public class ParkingsAction extends AbstractCRUDAction<ParkingData> {
	private static final long serialVersionUID = -6451550369473282420L;

	private ParkingService parkingService;
	private List<ParkingData> parkingsList = new ArrayList<ParkingData>();

	@Validations(
		requiredStrings = { 
			@RequiredStringValidator(fieldName = "parkingData.name", key = "${getRequiredFieldMessage(fieldName)}", shortCircuit = true),
			@RequiredStringValidator(fieldName = "parkingData.streetName", key = "${getRequiredFieldMessage(fieldName)}", shortCircuit = true)
		},
		requiredFields = {
			@RequiredFieldValidator(fieldName = "parkingData.capacity", key = "${getRequiredFieldMessage(fieldName)}", shortCircuit = true) 
		},
		intRangeFields = {
			@IntRangeFieldValidator(fieldName = "parkingData.capacity", key = "${getFieldRangeExceededMessage(fieldName, min, max)}", min = "0", max = "50", shortCircuit = true)
		}
	)
	public String save() throws Exception {
		this.managedEntity = parkingService.save(this.managedEntity);

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

	public String list() {
		this.parkingsList = this.parkingService.findAll();

		return LIST;
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
}
