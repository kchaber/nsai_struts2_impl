<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div class="col-sm-12 text-center navbar-brand brand col-sm-12 row" style="height: 100%">
	<div class="col-sm-1" style="cursor: pointer;" onclick="document.location='listParking.action';">
		<img style="border: 1px solid white;" src="images/logo.png" alt="logo" width="70" height="70"/>
	</div>
	<div class="col-sm-5 clearfix text-left" style="margin-top: 25px;">
		<p>
			<s:text name="header.title" />
		</p>
	</div>

	<s:if test="%{getLoggedUser() != null}">
		<div class="text-right clearfix">
			<s:a href="logout" theme="simple" cssClass="btn btn-danger btn-xs">
				<s:text name="buttons.logout" />
			</s:a>
		</div>
	</s:if>
	<s:else>
		<div class="text-right clearfix">
			<s:a href="inputLogin" theme="simple" cssClass="btn btn-warning btn-xs">
				<s:text name="buttons.login" />
			</s:a>
			<s:a href="inputRegister" theme="simple" cssClass="btn btn-warning btn-xs">
				<s:text name="buttons.register" />
			</s:a>
		</div>
	</s:else>

	<s:set var="isAdminUser" value="%{false}" />
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<s:set var="isAdminUser" value="%{true}" />
	</sec:authorize>
</div>