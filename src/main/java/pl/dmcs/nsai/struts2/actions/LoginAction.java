package pl.dmcs.nsai.struts2.actions;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import pl.dmcs.nsai.struts2.services.ParkingService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * The example login action using XML based configuration
 * @author KCH, JB
 *
 */
public class LoginAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -367541240516039861L;
	
	/**
	 * The name of the session parameter storing the user context of the current user
	 */
	public static final String USER_CONTEXT_PARAM_NAME = "USER_CONTEXT";
	
	private String username;
	private String password;
	
	private Map<String, Object> session = new HashMap<>();
	
	private ParkingService parkingService;
	
	public String login() throws Exception {
		//put the username to the session parameter
		this.session.put(USER_CONTEXT_PARAM_NAME, this.username);
		
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

	public ParkingService getParkingService() {
		return parkingService;
	}

	public void setParkingService(ParkingService parkingService) {
		this.parkingService = parkingService;
	}
}
