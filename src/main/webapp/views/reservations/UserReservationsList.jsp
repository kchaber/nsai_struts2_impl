<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="col-sm-12">
	<h2>
		<s:text name="userReservations.title" />
		<br />
	</h2>
	<s:form id="parkingForm" action="saveParking" method="POST">
		<s:set var="currBookingDate" value="" />

		<s:iterator value="activeReservations" var="parkingPlaceReservation" status="it">
			<s:if test="%{#it.index <= 0 || !#currBookingDate.equals(#parkingPlaceReservation.bookingDate)}">
				<br />
				<s:set var="currBookingDate" value="%{#parkingPlaceReservation.bookingDate}" />
				<h3>
					<s:text name="user.reservations.bookDate.title" />
					:&nbsp;
					<s:property value="%{#currBookingDate}" />
				</h3>
				<hr />
			</s:if>

			<div class="bg-info row" style="margin-bottom: 5px;">
				<div class="col-sm-1 text-left">
					<img style="float: left" src="images/parking_reservation_medium.png" alt="parking_reservation" />
				</div>
				<div class="col-sm-5 clearfix" style="margin-top: 10px;">
					<span>
						<s:text name="user.reservations.parking.title" />
						:&nbsp;
						<s:property value="%{#parkingPlaceReservation.parkingPlaceData.parkingData.name}" />
						,&nbsp;
						<s:property value="%{#parkingPlaceReservation.parkingPlaceData.parkingData.streetName}" />
					</span>
					<br />
					<span>
						<s:text name="user.reservations.place.title" />
						:&nbsp;
						<s:property value="%{#parkingPlaceReservation.parkingPlaceData.orderNum}" />
					</span>
				</div>
				<div class="button-group text-right" style="margin-top: 8px; margin-right: 10px;">
					<s:url var="deleteReservationUrl" action="removeUserReservation">
						<s:param name="selectedId" value="%{#parkingPlaceReservation.id}" />
					</s:url>
					<s:a href="%{#deleteReservationUrl}" theme="simple" cssClass="btn btn-danger btn-lg">
						<s:text name="buttons.delete" />
					</s:a>
				</div>
			</div>
		</s:iterator>
	</s:form>
</div>