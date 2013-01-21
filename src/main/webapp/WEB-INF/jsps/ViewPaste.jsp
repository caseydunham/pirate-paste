<%@ taglib uri="http://stripes.sourceforge.net/stripes.tld" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<s:layout-render name="Layout.jsp" pageTitle="home">
	<s:layout-component name="pageBody">
		<h3>Viewing Paste</h3>
		<c:choose>
			<c:when test="${actionBean.paste == null}">
				<h3>Paste not found!</h3>
			</c:when>
			<c:otherwise>
				<c:out value="${actionBean.paste.title}"/> - Posted by <c:out value="${actionBean.paste.username}"/> on
				<s:format value="${actionBean.paste.created}" formatPattern="EEE, dd MMM HH:mm"/><br/>
				<c:out value="${actionBean.paste.content}"/>
			</c:otherwise>
		</c:choose>
		<br/><br/>
		<s:link beanclass="net.caseydunham.pirate.stripes.action.HomeActionBean">new paste</s:link>
	</s:layout-component>
</s:layout-render>