<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- INCLUDE IT TO HAVE ACCESS TO THE STRUTS 2 TAGS --%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div>
	<s:actionerror/>

	<s:form method="POST" action="registerRegister">
		<s:textfield name="username" key="register.username" />
		<s:password name="password" key="register.password" />
		<s:password name="passwordConfirm" key="register.passwordConfirm" />

		<s:submit name="submit" key="buttons.register"/>
	</s:form>
</div>