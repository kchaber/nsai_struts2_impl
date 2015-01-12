<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="navbar-header col-sm-12">
	<div>
		<span class="col-sm-12 text-center navbar-brand">
			<s:text name="header.title" />
		</span>

		<s:url id="loginEN" namespace="/" action="locale">
			<s:param name="request_locale">en</s:param>
		</s:url>
		<s:url id="loginPL" namespace="/" action="locale">
			<s:param name="request_locale">pl</s:param>
		</s:url>

		<div class="text-right">
			<span>
				<s:a href="%{loginEN}">English</s:a>
			</span>
			<span>
				<s:a href="%{loginPL}">Polski</s:a>
			</span>
		</div>
	</div>
	
	<s:if test="%{getLoggedUser() != null}">
		<div class="text-right">
			<s:url var="logoutUrl" action="logoutLogin" />
			<s:a href="%{#logoutUrl}" theme="simple" cssClass="btn btn-danger btn-xs">
				<s:text name="buttons.logout" />
			</s:a>
		</div>
	</s:if>
</div>