<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="col-sm-6 col-sm-offset-3 well">
	<h2>
		<s:text name="register.title" />
	</h2>

	<s:form id="registrationForm" action="registerRegister" method="POST" cssClass="well">
		<s:textfield name="userData.login" key="userData.login" cssClass="form-control" />
		<s:textfield name="userData.firstName" key="userData.firstName" cssClass="form-control" />
		<s:textfield name="userData.lastName" key="userData.lastName" cssClass="form-control" />
		<s:textfield name="userData.email" key="userData.email" cssClass="form-control" />
		<s:password name="userData.passwordEncrypted" key="userData.passwordEncrypted" cssClass="form-control" />
		<s:password name="passwordConfirm" key="passwordConfirm" cssClass="form-control" />
		
		<div class="form-group form-actions">
			<img id="captchaImg" style="background: white;" src="<s:url action='generateCaptchaRegister'/>" alt="" height="50">
			<s:a cssClass="form-anchor" onclick="document.forms[0].captchaImg.src='<s:url action='generateCaptchaRegister'/>'+'?seed='+Math.random();">
				<s:text name="buttons.reloadCaptcha" />
			</s:a>
		</div>
		<s:textfield key="captchaAnswer" cssClass="form-control" />

		<div id="actions" class="form-group form-actions text-right">
			<s:submit type="button" method="register" key="buttons.register" theme="simple" cssClass="btn btn-primary" />
			<s:a action="inputLogin" theme="simple" cssClass="btn btn-xs btn-default">
				<s:text name="buttons.back" />
			</s:a>
		</div>
	</s:form>
</div>