<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<link rel="stylesheet" href="views/parkings/style.css">

<div class="col-sm-12 well">
	<h2>
		<s:text name="parkingPlaceReservationData.title" />
	</h2>	

	<s:form id="parkingplace-reservation-form" action="inputPlaceReservation" method="POST" cssClass="well">
		<s:hidden name="selectedParkingPlaceIndexesString" id="selectedParkingPlaceIndexesStringHidden" />

		<div class="form-group" style="margin-bottom: 20px;">
			<label class="label-control" style="margin-left: 40px;"><s:text name="parkingPlaceReservationData.bookingDate" />:</label>
			<sj:datepicker parentTheme="xhtml" cssClass="form-control" buttonImageOnly="true" cssStyle="margin-left: 40px; width: 100px;" name="parkingPlaceReservationData.bookingDate"
				onchange="reloadReservations();" minDate="%{getCurrentDate()}" />
		</div>

		<div id="selected-parking-places-div" style="margin-bottom: 20px; margin-left: 40px;"></div>

		<s:set var="baseWidth" value="50" />
		<s:set var="baseHeight" value="70" />
		<s:set var="currX" value="" />
		<s:set var="currY" value="" />
		<s:set var="localIndex" value="" />

		<div id="parking-map-div">
			<s:iterator value="parkingData.places" status="it" var="parkingPlace">
				<s:if test="%{#it.index <= 8}">
					<s:set var="localIndex" value="%{#it.index}" />
					<s:set var="currX" value="%{470 + #localIndex * (#baseWidth + 8)}" />
					<s:set var="currY" value="60" />
				</s:if>
				<s:elseif test="%{#it.index > 8 && #it.index <= 14}">
					<s:set var="localIndex" value="%{#it.index - 8}" />
					<s:set var="currX" value="%{590 + #localIndex * (#baseWidth + 8)}" />
					<s:set var="currY" value="215" />
				</s:elseif>
				<s:elseif test="%{#it.index > 14 && #it.index <= 20}">
					<s:set var="localIndex" value="%{#it.index - 14}" />
					<s:set var="currX" value="%{590 + #localIndex * (#baseWidth + 8)}" />
					<s:set var="currY" value="295" />
				</s:elseif>
				<s:elseif test="%{#it.index > 20 && #it.index <= 30}">
					<s:set var="localIndex" value="%{#it.index - 20}" />
					<s:set var="currX" value="%{275 + #localIndex * (#baseWidth + 11)}" />
					<s:set var="currY" value="465" />
				</s:elseif>
				<s:elseif test="%{#it.index > 30 && #it.index <= 40}">
					<s:set var="localIndex" value="%{#it.index - 30}" />
					<s:set var="currX" value="%{270 + #localIndex * (#baseWidth + 12)}" />
					<s:set var="currY" value="545" />
				</s:elseif>


				<s:set var="positions" value="%{'margin-left: ' + #currX + 'px; margin-top: ' + #currY + 'px; width: ' + #baseWidth + 'px; height: ' + #baseHeight + 'px;'}" />
				<s:if test="%{isPlaceReserved(#parkingPlace)}">
					<div parking-place-index='<s:property value="#it.index"/>' class="parking-position booked" style="<s:property value='%{#positions}'/>" title="ALREADY RESERVED">
						<s:property value="#parkingPlace.orderNum" />
					</div>
				</s:if>
				<s:else>
					<div parking-place-index='<s:property value="#it.index"/>' class="parking-position available" style="<s:property value='%{#positions}'/>" onclick="toggleSelectParkingPlace($(this));">
						<s:property value="#parkingPlace.orderNum" />
					</div>
				</s:else>
			</s:iterator>
		</div>

		<s:url var="listSelectedParkingPlacesUrl" action="ajaxListSelectedPlaceReservation" />
		<sj:submit id="listSelectedParkingPlacesButton" formIds="parkingplace-reservation-form" targets="selected-parking-places-div" href="%{#listSelectedParkingPlacesUrl}" cssStyle="display: none;" />

		<s:submit id="reloadReservationsButton" type="button" action="listReservedPlaceReservation" theme="simple" cssStyle="display: none;" />

		<div class="form-group form-actions text-right">
			<s:submit id="createReservationsButton" type="button" action="savePlaceReservation" key="buttons.save" theme="simple" cssClass="btn btn-primary" />
			<s:a action="modifyParking" theme="simple" cssClass="btn btn-xs btn-default"><s:text name="buttons.back"/></s:a>
		</div>
	</s:form>
</div>
<script>
	function reloadReservations() {
		$("#reloadReservationsButton").click();
	}

	function toggleSelectParkingPlace(parkingPlaceDiv) {
		parkingPlaceDiv.toggleClass("available");
		parkingPlaceDiv.toggleClass("selected");

		collectSelectedParkingPlaces();
		$("#listSelectedParkingPlacesButton").click();
	}

	function collectSelectedParkingPlaces() {
		var ids = "";
		$(".selected").each(function() {
			ids += $(this).attr("parking-place-index") + ",";
		});
		$("#selectedParkingPlaceIndexesStringHidden").val(ids);
	}

	//WORKAROUND FOR THE JQUERY SUBMIT BUTTON
	$(document).ready(function() {
		$("#reloadReservationsButton").click(function(e) {
			e.preventDefault();
			this.form.action = "listReservedPlaceReservation";
			this.form.submit();
		});

		$("#createReservationsButton").click(function(e) {
			e.preventDefault();
			this.form.action = "savePlaceReservation";
			this.form.submit();
		});
	});

	
</script>