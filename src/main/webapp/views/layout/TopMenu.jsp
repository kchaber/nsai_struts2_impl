<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div style="background: #ff7373">
	<span style="color: black"><s:text name="menu.example"/></span>
	<s:form method="POST">
		<s:submit action="testOtherAction" value="test other action"/>
		<s:submit action="listParking" value="Parkings"/>
		<s:submit action="listUser" value="Users"/>
	</s:form>
</div>
