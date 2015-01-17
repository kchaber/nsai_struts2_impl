package pl.dmcs.nsai.struts2.actions.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import pl.dmcs.nsai.struts2.actions.AbstractCRUDAction;
import pl.dmcs.nsai.struts2.entities.UserData;
import pl.dmcs.nsai.struts2.services.UserService;

import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.FieldExpressionValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

public class UsersAction extends AbstractCRUDAction<UserData> {
	private static final long serialVersionUID = -2619159570069950L;
	
	protected UserService userService;
	protected List<UserData> usersList = new ArrayList<UserData>();
	
	private String changePassword;
	private String changePasswordConfirm;
	
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
		},
		fieldExpressions = {
			@FieldExpressionValidator(fieldName = "changePasswordConfirm", expression = "changePassword == null || changePassword == '' || changePassword eq changePasswordConfirm", message = "${getText('errors.invalidpasswordConfirm')}", shortCircuit = true)
		}
	)
	public String save() throws Exception {
		if (!StringUtils.isEmpty(this.changePassword)) {
			String encodedPass = this.userService.encodePassword(this.changePassword);
			this.managedEntity.setPasswordEncrypted(encodedPass);
		}
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

	@Override
	public String list() {
		this.usersList = this.userService.findAll();

		return LIST;
	}

	@Override
	public void removeManagedEntity(Integer id) {
		if (this.getLoggedUser() != null && !id.equals(this.getLoggedUser().getId())) {
			this.userService.remove(id);
		}
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

	public String getChangePassword() {
		return changePassword;
	}

	public void setChangePassword(String changePassword) {
		this.changePassword = changePassword;
	}

	public String getChangePasswordConfirm() {
		return changePasswordConfirm;
	}

	public void setChangePasswordConfirm(String changePasswordConfirm) {
		this.changePasswordConfirm = changePasswordConfirm;
	}
}
