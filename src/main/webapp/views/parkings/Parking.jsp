<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="col-sm-6 col-sm-offset-3">
	<s:form id="parkingForm" action="saveParking" method="POST" cssClass="well">
		<s:if test="%{parkingData.id != null}">
			<s:textfield name="parkingData.id" key="parkingData.id" disabled="true" cssClass="form-control"/>
		</s:if>
		<s:textfield name="parkingData.name" key="parkingData.name" cssClass="form-control"/>
		<s:textfield name="parkingData.streetName" key="parkingData.streetName" cssClass="form-control"/>
		<s:textfield name="parkingData.capacity" key="parkingData.capacity" disabled="%{parkingData.aggregateBookedPlacesSize > 0}" cssClass="form-control" />

		<div id="actions" class="form-group form-actions text-right">
			<s:submit type="button" method="save" key="buttons.save" theme="simple" cssClass="btn btn-primary"/>
			<s:if test="%{parkingData.id != null}">
				<s:submit type="button" method="delete" key="buttons.delete" theme="simple" cssClass="btn btn-danger"/>
				<s:submit type="button" action="inputPlaceReservation" key="buttons.bookPlace" theme="simple" cssClass="btn btn-info"/>
			</s:if>
			<s:a action="listParking" theme="simple" cssClass="btn btn-xs btn-default"><s:text name="buttons.back"/></s:a>
		</div>
	</s:form>
</div>