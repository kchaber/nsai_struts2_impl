<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="navbar-header">
	<s:form method="POST">
		<s:a action="listParking" theme="simple" cssClass="navbar-link navbar-brand"><s:text name="menu.parkings.title"/></s:a>
		
		<s:a action="listUser" theme="simple" cssClass="navbar-link navbar-brand"><s:text name="menu.users.title"/></s:a>

		<s:if test="%{getLoggedUser() != null}">
			<s:a action="listUserReservation" theme="simple" cssClass="navbar-link navbar-brand">
				<s:text name="menu.myReservations.title" />
			</s:a>
		</s:if>
	</s:form>
</div>