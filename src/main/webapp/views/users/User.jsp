<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="col-sm-6 col-sm-offset-3">
	<h2>
		<s:text name="user.title" />
		<br />
	</h2>

	<s:form id="userForm" action="saveUser" method="POST" cssClass="well">
		<s:if test="%{userData.id != null}">
			<s:textfield name="userData.id" key="userData.id" disabled="true" cssClass="form-control" />
		</s:if>
		<s:textfield name="userData.login" key="userData.login" disabled="true" cssClass="form-control" />
		<s:textfield name="userData.firstName" key="userData.firstName" cssClass="form-control" />
		<s:textfield name="userData.lastName" key="userData.lastName" cssClass="form-control" />
		<s:textfield name="userData.email" key="userData.email" cssClass="form-control" />
		
		<s:password key="changePassword" cssClass="form-control" autocomplete="off"/>
		<s:password key="changePasswordConfirm" cssClass="form-control" />

		<div id="actions" class="form-group form-actions text-right">
			<s:if test="%{#isAdminUser || userData.equals(getLoggedUser())}">
				<s:submit type="button" method="save" key="buttons.save" theme="simple" cssClass="btn btn-primary" />
				<s:if test="%{userData.id != null && !userData.equals(getLoggedUser())}">
					<s:url var="deleteUserUrl" action="removeUser">
						<s:param name="selectedId" value="%{userData.id}" />
					</s:url>
					<s:a href="%{#deleteUserUrl}" theme="simple" cssClass="btn btn-danger">
						<s:text name="buttons.delete" />
					</s:a>
				</s:if>
			</s:if>
			<s:a action="listUser" theme="simple" cssClass="btn btn-xs btn-default">
				<s:text name="buttons.back" />
			</s:a>
		</div>
	</s:form>
</div>