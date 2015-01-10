package pl.dmcs.nsai.struts2.actions.login;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import pl.dmcs.nsai.struts2.actions.AbstractAction;
import pl.dmcs.nsai.struts2.entities.UserData;
import pl.dmcs.nsai.struts2.services.UserService;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

/**
 * The example login action using XML based configuration
 * @author KCH, JB
 *
 */
public class LoginAction extends AbstractAction implements SessionAware {
	private static final long serialVersionUID = -367541240516039861L;
	
	/**
	 * The name of the session parameter storing the user context of the current user
	 */
	public static final String USER_CONTEXT_PARAM_NAME = "USER_CONTEXT";
	
	private String username;
	private String password;
	
	private Map<String, Object> session = new HashMap<>();
	
	private UserService userService;
	
	@Validations(
		requiredStrings = { 
			@RequiredStringValidator(fieldName = "username", key = "${getRequiredFieldMessage(fieldName)}", shortCircuit = true),
			@RequiredStringValidator(fieldName = "password", key = "${getRequiredFieldMessage(fieldName)}", shortCircuit = true)
		}
	)
	public String login() throws Exception {
		UserData loggedUser = this.userService.loginUser(this.username, this.password);
		if (loggedUser == null) {
			this.addFieldError("username", getText("erorrs.loginFailed"));
			return INPUT;
		}
		
		//put the username to the session parameter
		this.session.put(USER_CONTEXT_PARAM_NAME, loggedUser);
		
		return SUCCESS;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
