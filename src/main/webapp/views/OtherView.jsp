<%-- ADDED TO HAVE ACCESS TO THE STRUTS 2 TAGS --%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%-- ADDED TO HAVE ACCESS TO THE STRUTS 2 JQUERY TAGS (THOSE WITH AJAX SUPPORT) --%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<sj:head />

<s:form id="other-form" method="POST" theme="simple">
	<span>SOME OTHER VIEW</span>
	<div id="string-lists" style="width: 500px; background: #afeeee; padding: 50px;">
		<jsp:include page="ajax/StringsList.jsp" />
	</div>
</s:form>
