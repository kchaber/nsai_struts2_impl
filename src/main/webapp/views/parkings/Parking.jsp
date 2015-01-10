<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div>
	<s:form id="parkingForm" action="saveParking" method="POST">
		<s:if test="%{parkingData.id != null}">
			<s:textfield name="parkingData.id" key="parkingData.id" disabled="true" />
		</s:if>
		<s:textfield name="parkingData.name" key="parkingData.name" />
		<s:textfield name="parkingData.streetName" key="parkingData.streetName" />
		<s:textfield name="parkingData.capacity" key="parkingData.capacity" />
		
		<div id="actions">
			<s:submit type="button" method="save" key="buttons.save" theme="simple">

			</s:submit>
			<s:if test="%{parkingData.id != null}">
				<s:submit type="button" method="delete" key="buttons.delete" theme="simple">
					Delete
				</s:submit>
			</s:if>
			<s:submit type="button" action="listParking" key="buttons.cancel" theme="simple">
				Cancel
			</s:submit>
		</div>
	</s:form>
</div>