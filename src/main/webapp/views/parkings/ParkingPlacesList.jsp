<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<style>
#parking-map-div {
	background-image: url('images/parking_map.jpg');
	width: 1000px;
	height: 650px;
	position: relative;
	margin-left: 50px;
	height: 650px;
	position: relative;
}

.parking-position {
	position: absolute;
	opacity: 0.6;
	cursor: pointer;
}

.parking-position.available {
	background-color: #48b427;
}

.parking-position.available:HOVER {
	background-color: #49ff45;
}

.parking-position.booked {
	background-color: #ff8100;
}

.parking-position.booked:HOVER {
	background-color: #f2b50f;
}
</style>

<div>
	<s:form id="parkingPlaceReservationForm" action="reservePlaceParking" method="POST">
		<sj:datepicker name="parkingPlaceReservationData.bookingDate" />

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
				<s:set var="classes" value="'parking-position'" />
				<s:if test="%{isPlaceReserved(#parkingPlace)}">
					<s:set var="classes" value="%{#classes + ' booked'}" />
				</s:if>
				<s:else>
					<s:set var="classes" value="%{#classes + ' available'}" />
				</s:else>
				<s:set var="positions" value="%{'margin-left: ' + #currX + 'px; margin-top: ' + #currY + 'px; width: ' + #baseWidth + 'px; height: ' + #baseHeight + 'px;'}" />

				<div class="<s:property value='%{#classes}'/>" style="<s:property value='%{#positions}'/>"></div>
			</s:iterator>
		</div>

		<s:submit type="button" action="testCreatePlaceReservation" key="buttons.save" theme="simple">
					TEST
		</s:submit>

	</s:form>
</div>
