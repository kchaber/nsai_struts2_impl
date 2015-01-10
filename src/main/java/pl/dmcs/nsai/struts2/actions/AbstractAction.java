package pl.dmcs.nsai.struts2.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public abstract class AbstractAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	private static final long serialVersionUID = -5991763491081038818L;

	protected HttpServletRequest request;

	protected HttpServletResponse response;

	public static final String LIST = "list";

	public String getRequiredFieldMessage(String fieldName) {
		return this.getText("errors.required", new String[] { this.getText(fieldName, fieldName) });
	}
	
	public String getFieldRangeExceededMessage(String fieldName, int min, int max) {
		return this.getText("errors.rangeExceeded", new String[] {this.getText(fieldName, fieldName), String.valueOf(min), String.valueOf(max)});
	}
	
	public String getInvalidEmailFieldMessage(String fieldName) {
		return this.getText("errors.invalidEmail", new String[] {this.getText(fieldName, fieldName)});
	}

	public String getActionName() {
		return ActionContext.getContext().getName();
	}
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}
}
