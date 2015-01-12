<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- INCLUDE IT TO HAVE ACCESS TO THE STRUTS 2 TAGS --%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="col-sm-4 col-sm-offset-4">
	<h2>
		<s:text name="login.title" />
	</h2>

	<s:form method="POST" action="loginLogin" cssClass="well">
		<s:textfield name="username" key="login.username" cssClass="form-control" />
		<s:password name="password" key="login.password" cssClass="form-control" />

		<div class="form-group form-actions text-right">
			<s:submit name="submit" key="buttons.login" cssClass="btn btn-primary" theme="simple" />
			<s:a action="inputRegister" cssClass="btn btn-default" theme="simple">
				<s:text name="buttons.register" />
			</s:a>
		</div>
	</s:form>
</div>