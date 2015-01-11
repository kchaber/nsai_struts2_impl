<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:iterator var="selectedParkingPlace" value="selectedParkingPlaces">
	<div class="bg-info" style="width: 1000px; margin-bottom: 5px; border: 2px solid #0266c8;">
		<img src="images/parking_reservation.png" alt="parking_reservation" />
		<span>
			Place number: <s:property value="%{#selectedParkingPlace.orderNum}" />
		</span>
	</div>
</s:iterator>
