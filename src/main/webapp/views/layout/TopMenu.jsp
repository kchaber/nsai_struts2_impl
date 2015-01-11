<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="navbar-header">
	<s:form method="POST">
		<s:a action="listParking" theme="simple" cssClass="navbar-link navbar-brand">Parkings</s:a>
		<s:a action="listUser" theme="simple" cssClass="navbar-link navbar-brand">Users</s:a>
	</s:form>
</div>