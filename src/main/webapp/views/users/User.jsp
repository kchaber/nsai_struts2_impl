<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="col-sm-6 col-sm-offset-3">
	<s:form id="userForm" action="saveUser" method="POST" cssClass="well">
		<s:if test="%{userData.id != null}">
			<s:textfield name="userData.id" key="userData.id" disabled="true" cssClass="form-control"/>
		</s:if>
		<s:textfield name="userData.login" key="userData.login" disabled="true" cssClass="form-control"/>
		<s:textfield name="userData.firstName" key="userData.firstName" cssClass="form-control" />
		<s:textfield name="userData.lastName" key="userData.lastName" cssClass="form-control"/>
		<s:textfield name="userData.email" key="userData.email" cssClass="form-control"/>
		
		<div id="actions" class="form-group form-actions text-right">
			<s:submit type="button" method="save" key="buttons.save" theme="simple" cssClass="btn btn-primary">

			</s:submit>
			<s:if test="%{userData.id != null}">
				<s:submit type="button" method="delete" key="buttons.delete" theme="simple" cssClass="btn btn-danger"/>
			</s:if>
			<s:a action="listUser" theme="simple" cssClass="btn btn-xs btn-default"><s:text name="buttons.back"/></s:a>
		</div>
	</s:form>
</div>