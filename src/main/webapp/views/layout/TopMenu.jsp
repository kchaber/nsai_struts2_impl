<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<nav  class="navbar navbar-form navbar-left">
	<s:form method="POST">
		<s:a action="listParking" theme="simple" cssClass="navbar-link navbar-brand"><s:text name="menu.parkings.title"/></s:a>
		
		<s:a action="listUser" theme="simple" cssClass="navbar-link navbar-brand"><s:text name="menu.users.title"/></s:a>

		<s:if test="%{getLoggedUser() != null}">
			<s:a action="listUserReservation" theme="simple" cssClass="navbar-link navbar-brand">
				<s:text name="menu.myReservations.title" />
			</s:a>
			
			<s:url var="modifyMyUserUrl" action="modifyUser">
				<s:param name="selectedId" value="%{getLoggedUser().id}"/>
			</s:url>
			<s:a href="%{#modifyMyUserUrl}" theme="simple" cssClass="navbar-link navbar-brand">
				<s:text name="menu.myUser.title" />
			</s:a>
		</s:if>
	</s:form>
</nav>