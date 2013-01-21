<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://stripes.sourceforge.net/stripes.tld" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<s:layout-definition>
	<!DOCTYPE html>
	<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Pirate Paste</title>
		<base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
	</head>

	<body>
	<h1>Pirate Paste</h1>

	<div id="content">
		<s:messages />
		<s:errors />
		<h3>Recent Pastes</h3>
		<ul>
			<c:forEach var="paste" items="${actionBean.recentPastes}">
				<li>
					<a href="/pastes/${paste.id}">${paste.title}</a> - ${paste.username}</li>
			</c:forEach>
		</ul>
		<s:layout-component name="pageBody"/>
		<s:layout-component name="postRender"/>
	</div>
	</body>
	</html>
</s:layout-definition>