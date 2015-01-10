<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>

<div>
	<display:table name="usersList">
		<display:column property="id" paramId="selectedId" paramProperty="id" sortable="true" href="modifyUser" media="html" titleKey="userData.id" />
		<display:column property="login" sortable="true" titleKey="userData.login" />
		<display:column property="firstName" sortable="true" titleKey="userData.firstName" />
		<display:column property="lastName" sortable="true" titleKey="userData.lastName" />
		<display:column property="email" sortable="true" titleKey="userData.email" />
	</display:table>
</div>