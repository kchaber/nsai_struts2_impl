<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="navbar-header col-sm-12">

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
		<span> <s:a href="%{loginEN}">English</s:a></span> <span> <s:a href="%{loginPL}">Polski</s:a></span>
	</div>
</div>