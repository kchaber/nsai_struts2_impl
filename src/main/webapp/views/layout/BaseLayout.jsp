<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%@include file="CommonIncludes.jsp"%>

<title>Struts 2 NSAI</title>
</head>
<body>
	<div id="app-header" class="col-sm-12">
		<tiles:insertAttribute name="header" />
	</div>

	<div id="app-body" class="container">
		<div class="col-sm-12 text-left messages">
			<s:actionmessage/>
			<s:actionerror cssClass="action-error"/>
		</div>
		<tiles:insertAttribute name="body" />
	</div>

	<div id="app-footer" class="footer opacity" style="margin-top: 120px; height: 80px;">
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>
