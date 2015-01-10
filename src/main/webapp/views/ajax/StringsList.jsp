<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>


<span><s:text name="other.appendStrings" /></span>
<br />

<s:actionerror />

<s:iterator var="string" value="strings">
		"<s:property value="#string" />"
		<br />
</s:iterator>

<%-- the new string to add --%>
<s:textfield name="someString" key="other.someString" />

<%-- an URL to the action responsible for add string to the list --%>
<s:url id="addStringUrl" action="addStringAjaxAction" />
<%-- AJAX action call
     	 * string-lists - the id of the HTML element which must be reloaded after ajax call.
     	 defined in the OtherView.jsp
 	--%>
<sj:submit formIds="other-form" targets="string-lists" key="buttons.add" href="%{addStringUrl}" />
