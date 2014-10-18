<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>


<s:textfield name="someString" key="labels.other.someString" />

<s:url id="addStringUrl" action="addStringAjaxAction" />

<sj:submit formIds="other-form" targets="string-lists" key="buttons.add" href="%{addStringUrl}" />
