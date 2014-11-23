package pl.dmcs.nsai.struts2.actions;


import pl.dmcs.nsai.struts2.services.ParkingService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author KCH, JB
 *
 */
public class OtherAction extends ActionSupport  {
	private static final long serialVersionUID = -8898652825877486009L;
	
	private ParkingService parkingService;
	
	public String test() throws Exception {
		
		return SUCCESS;
	}
}
