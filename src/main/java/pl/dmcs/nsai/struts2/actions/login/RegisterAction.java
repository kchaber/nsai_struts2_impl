package pl.dmcs.nsai.struts2.actions.login;

import pl.dmcs.nsai.struts2.actions.user.UsersAction;
import pl.dmcs.nsai.struts2.entities.UserData;

import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.ExpressionValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

public class RegisterAction extends UsersAction {
	private static final long serialVersionUID = 4015831356927099023L;
	
	private String passwordConfirm;
	
	@Validations(
		requiredStrings = { 
			@RequiredStringValidator(fieldName = "userData.login", key = "${getRequiredFieldMessage(fieldName)}", shortCircuit = true),
			@RequiredStringValidator(fieldName = "userData.firstName", key = "${getRequiredFieldMessage(fieldName)}", shortCircuit = true),
			@RequiredStringValidator(fieldName = "userData.lastName", key = "${getRequiredFieldMessage(fieldName)}", shortCircuit = true),
			@RequiredStringValidator(fieldName = "userData.passwordEncrypted", key = "${getRequiredFieldMessage(fieldName)}", shortCircuit = true),
			@RequiredStringValidator(fieldName = "passwordConfirm", key = "${getRequiredFieldMessage(fieldName)}", shortCircuit = true),
			@RequiredStringValidator(fieldName = "userData.email", key = "${getRequiredFieldMessage(fieldName)}", shortCircuit = true)
		},
		expressions = {
			@ExpressionValidator(expression = "userData.passwordEncrypted eq passwordConfirm", message = "${getText('errors.invalidpasswordConfirm')}", shortCircuit = true)
		},
		emails = {
			@EmailValidator(fieldName = "userData.email", key = "${getInvalidEmailFieldMessage(fieldName)}")
		}
	)
	public String register() throws Exception {
		UserData user = this.userService.findByLogin(this.getUserData().getLogin());
		if (user != null) {
			this.addFieldError("userData.login", getText("errors.loginExists"));
			return INPUT;
		}
		
		this.userService.save(this.managedEntity);
		
		return SUCCESS;
	}

	@Override
	protected void reset() {
		super.reset();
		this.passwordConfirm = null;
	}
	
	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
}
