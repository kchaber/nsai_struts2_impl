<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>

<div>
	<div id="actions">
		<a href="<s:url value="/createParking"/>"> ADD </a>
	</div>

	<display:table name="parkingsList">
		<display:column property="id" paramId="selectedId" paramProperty="id" sortable="true" href="modifyParking" media="html" titleKey="parkingData.id" />
		<display:column property="name" sortable="true" titleKey="parkingData.name" />
		<display:column property="streetName" sortable="true" titleKey="parkingData.streetName" />
		<display:column property="capacity" sortable="true" titleKey="parkingData.capacity" />
	</display:table>
</div>