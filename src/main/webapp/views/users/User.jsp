<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div>
	<s:form id="userForm" action="saveUser" method="POST">
		<s:if test="%{userData.id != null}">
			<s:textfield name="userData.id" key="userData.id" disabled="true" />
		</s:if>
		<s:textfield name="userData.login" key="userData.login" disabled="true"/>
		<s:textfield name="userData.firstName" key="userData.firstName" />
		<s:textfield name="userData.lastName" key="userData.lastName"/>
		<s:textfield name="userData.email" key="userData.email"/>
		
		<div id="actions">
			<s:submit type="button" method="save" key="buttons.save" theme="simple">

			</s:submit>
			<s:if test="%{userData.id != null}">
				<s:submit type="button" method="delete" key="buttons.delete" theme="simple">
					Delete
				</s:submit>
			</s:if>
			<s:submit type="button" action="listUser" key="buttons.cancel" theme="simple">
				Cancel
			</s:submit>
		</div>
	</s:form>
</div>