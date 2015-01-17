package pl.dmcs.nsai.struts2.actions.login;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import nl.captcha.Captcha;
import nl.captcha.gimpy.DropShadowGimpyRenderer;
import nl.captcha.servlet.CaptchaServletUtil;
import nl.captcha.text.producer.DefaultTextProducer;
import pl.dmcs.nsai.struts2.actions.user.UsersAction;
import pl.dmcs.nsai.struts2.entities.UserData;

import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.FieldExpressionValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

public class RegisterAction extends UsersAction {
	private static final long serialVersionUID = 4015831356927099023L;
	
	public static final String CAPTCHA = "captcha";
	
	private InputStream inputStream;
	private String passwordConfirm;
	private String captchaGeneratedAnswer;
	private String captchaAnswer;
	
	@Validations(
		requiredStrings = { 
			@RequiredStringValidator(fieldName = "userData.login", key = "${getRequiredFieldMessage(fieldName)}", shortCircuit = true),
			@RequiredStringValidator(fieldName = "userData.firstName", key = "${getRequiredFieldMessage(fieldName)}", shortCircuit = true),
			@RequiredStringValidator(fieldName = "userData.lastName", key = "${getRequiredFieldMessage(fieldName)}", shortCircuit = true),
			@RequiredStringValidator(fieldName = "userData.passwordEncrypted", key = "${getRequiredFieldMessage(fieldName)}", shortCircuit = true),
			@RequiredStringValidator(fieldName = "passwordConfirm", key = "${getRequiredFieldMessage(fieldName)}", shortCircuit = true),
			@RequiredStringValidator(fieldName = "userData.email", key = "${getRequiredFieldMessage(fieldName)}", shortCircuit = true),
			@RequiredStringValidator(fieldName = "captchaAnswer", key = "${getRequiredFieldMessage(fieldName)}", shortCircuit = true)
		},
		fieldExpressions = {
				@FieldExpressionValidator(fieldName = "userData.passwordEncrypted", expression = "userData.passwordEncrypted eq passwordConfirm", message = "${getText('errors.invalidpasswordConfirm')}", shortCircuit = true),
				@FieldExpressionValidator(fieldName = "captchaAnswer", expression = "captchaAnswer eq captchaGeneratedAnswer", message = "${getText('errors.invalidCaptcha')}", shortCircuit = true)
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
	
	public String generateCaptcha() throws Exception {
		Captcha captcha = new Captcha.Builder(200, 50)
				.addText(new DefaultTextProducer())
				.gimp(new DropShadowGimpyRenderer())
				.addNoise()
				.addBackground()
				.build();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		// write the image
		CaptchaServletUtil.writeImage(outputStream, captcha.getImage());
		// store the answer for this in session
		this.captchaGeneratedAnswer = captcha.getAnswer();
		
		// return image
		inputStream = new ByteArrayInputStream(outputStream.toByteArray());
		return CAPTCHA;
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

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getCaptchaGeneratedAnswer() {
		return captchaGeneratedAnswer;
	}

	public void setCaptchaGeneratedAnswer(String captchaGeneratedAnswer) {
		this.captchaGeneratedAnswer = captchaGeneratedAnswer;
	}

	public String getCaptchaAnswer() {
		return captchaAnswer;
	}

	public void setCaptchaAnswer(String captchaAnswer) {
		this.captchaAnswer = captchaAnswer;
	}
}
