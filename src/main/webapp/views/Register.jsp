<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="col-sm-4 col-sm-offset-4">
	<h2><s:text name="register.title"/></h2>

	<s:form id="registrationForm" action="registerRegister" method="POST" cssClass="well">
		<s:textfield name="userData.login" key="userData.login" cssClass="form-control" />
		<s:textfield name="userData.firstName" key="userData.firstName" cssClass="form-control" />
		<s:textfield name="userData.lastName" key="userData.lastName" cssClass="form-control" />
		<s:textfield name="userData.email" key="userData.email" cssClass="form-control" />
		<s:password name="userData.passwordEncrypted" key="userData.passwordEncrypted" cssClass="form-control" />
		<s:password name="passwordConfirm" key="passwordConfirm" cssClass="form-control" />

		<div id="actions" class="form-group form-actions text-right">
			<s:submit type="button" method="register" key="buttons.register" theme="simple" cssClass="btn btn-primary"/>
			<s:submit type="button" action="inputLogin" key="buttons.cancel" theme="simple" cssClass="btn btn-xs btn-default"/>
		</div>
	</s:form>
</div>