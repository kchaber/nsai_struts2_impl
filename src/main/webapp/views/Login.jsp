<%-- INCLUDE ITS TO HAVE ACCESS TO THE STRUTS 2 TAGS --%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div>
	<s:actionerror/>

	<s:form method="POST" action="loginLogin">
		<s:textfield name="username" key="labels.login.username"/>
		<s:password name="password" key="labels.login.password"/>
		
		<s:submit name="submit" key="buttons.login"/>
		<s:submit name="submit" key="buttons.register" action="inputRegister"/>
	</s:form>
</div>