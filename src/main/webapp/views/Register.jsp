<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div>
	<s:actionerror />

	<s:form id="registrationForm" action="registerRegister" method="POST">
		<s:textfield name="userData.login" key="userData.login" />
		<s:textfield name="userData.firstName" key="userData.firstName" />
		<s:textfield name="userData.lastName" key="userData.lastName" />
		<s:textfield name="userData.email" key="userData.email" />
		<s:password name="userData.passwordEncrypted" key="userData.passwordEncrypted" />
		<s:password name="passwordConfirm" key="passwordConfirm" />

		<div id="actions">
			<s:submit type="button" method="register" key="buttons.register" theme="simple">

			</s:submit>
			<s:submit type="button" action="inputLogin" key="buttons.cancel" theme="simple">
				Cancel
			</s:submit>
		</div>
	</s:form>
</div>