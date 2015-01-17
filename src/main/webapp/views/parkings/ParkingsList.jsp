<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>

<div class="col-sm-12">
	<h2>
		<s:text name="parkingsList.title" />
		<br />
	</h2>

	<s:if test="%{#isAdminUser}">
		<div id="actions" class="btn-group" style="margin-bottom: 20px;">
			<a class="btn btn-primary" href="<s:url value="/createParking"/>"> <i class="icon-plus icon-white"></i> <s:text name="buttons.add" />
			</a>
		</div>
	</s:if>


	<display:table name="parkingsList" class="table table-condensed table-striped table-bordered table-hover" requestURI="" id="parkingsList">
		<display:column property="id" paramId="selectedId" paramProperty="id" sortable="true" href="modifyParking" media="html" titleKey="parkingData.id" />
		<display:column property="name" sortable="true" titleKey="parkingData.name" />
		<display:column property="streetName" sortable="true" titleKey="parkingData.streetName" />
		<display:column property="capacity" sortable="true" titleKey="parkingData.capacity" />
	</display:table>
</div>