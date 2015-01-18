<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="col-sm-6 col-sm-offset-3 well">
	<h2>
		<s:text name="parking.title" />
		<br />
	</h2>

	<s:form id="parkingForm" action="saveParking" method="POST" cssClass="well">
		<s:if test="%{parkingData.id != null}">
			<s:textfield name="parkingData.id" key="parkingData.id" disabled="true" cssClass="form-control" />
		</s:if>
		<s:textfield name="parkingData.name" key="parkingData.name" cssClass="form-control" />
		<s:textfield name="parkingData.streetName" key="parkingData.streetName" cssClass="form-control" />
		<s:textfield name="parkingData.capacity" key="parkingData.capacity" cssClass="form-control" disabled="%{parkingData.id != null}" />

		<div id="actions" class="form-group form-actions text-right">
			<s:if test="%{#isAdminUser}">
				<s:submit type="button" method="save" key="buttons.save" theme="simple" cssClass="btn btn-primary" />
			</s:if>
			<s:if test="%{parkingData.id != null}">
				<s:if test="%{#isAdminUser}">
					<s:url var="deleteParkingUrl" action="removeParking">
						<s:param name="selectedId" value="%{parkingData.id}" />
					</s:url>
					<s:a href="%{#deleteParkingUrl}" theme="simple" cssClass="btn btn-danger">
						<s:text name="buttons.delete" />
					</s:a>
				</s:if>

				<s:url var="inputPlaceReservationUrl" action="inputPlaceReservation">
					<s:param name="selectedId" value="%{parkingData.id}" />
				</s:url>
				<s:a href="%{#inputPlaceReservationUrl}" theme="simple" cssClass="btn btn-info">
					<s:text name="buttons.bookPlace" />
				</s:a>
			</s:if>

			<s:a action="listParking" theme="simple" cssClass="btn btn-xs btn-default">
				<s:text name="buttons.back" />
			</s:a>
		</div>
	</s:form>
</div>