package pl.dmcs.nsai.struts2.actions.user;

import java.util.ArrayList;
import java.util.List;

import pl.dmcs.nsai.struts2.actions.AbstractCRUDAction;
import pl.dmcs.nsai.struts2.entities.UserData;
import pl.dmcs.nsai.struts2.services.UserService;

import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

public class UsersAction extends AbstractCRUDAction<UserData> {
	private static final long serialVersionUID = -2619159570069950L;
	
	protected UserService userService;
	protected List<UserData> usersList = new ArrayList<UserData>();
	
	@Validations(
		requiredStrings = { 
			@RequiredStringValidator(fieldName = "userData.login", key = "${getRequiredFieldMessage(fieldName)}", shortCircuit = true),
			@RequiredStringValidator(fieldName = "userData.firstName", key = "${getRequiredFieldMessage(fieldName)}", shortCircuit = true),
			@RequiredStringValidator(fieldName = "userData.lastName", key = "${getRequiredFieldMessage(fieldName)}", shortCircuit = true),
			@RequiredStringValidator(fieldName = "userData.passwordEncrypted", key = "${getRequiredFieldMessage(fieldName)}", shortCircuit = true),
			@RequiredStringValidator(fieldName = "userData.email", key = "${getRequiredFieldMessage(fieldName)}", shortCircuit = true)
		},
		emails = {
			@EmailValidator(fieldName = "userData.email", key = "${getInvalidEmailFieldMessage(fieldName)}")
		}
	)
	public String save() throws Exception {
		this.managedEntity = userService.save(this.managedEntity);

		this.addActionMessage(getText("actionMessages.operationSuccessful"));
		
		return SUCCESS;
	}

	@Override
	public UserData loadManagedEntity(Integer id) {
		return this.userService.findById(id);
	}
	
	@Override
	protected void reset() {
		super.reset();
		this.managedEntity = new UserData();
	}

	public String list() {
		this.usersList = this.userService.findAll();

		return LIST;
	}

	public UserData getUserData() {
		return this.managedEntity;
	}

	public void setUserData(UserData userData) {
		this.managedEntity = userData;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<UserData> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<UserData> usersList) {
		this.usersList = usersList;
	}
}
