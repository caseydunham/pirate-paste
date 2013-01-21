<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://stripes.sourceforge.net/stripes.tld" prefix="s" %>
<s:layout-definition>
	<!DOCTYPE html>
	<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Pirate Paste</title>
		<base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">

		<s:layout-component name="htmlHead"/>
	</head>

	<body>
	<h1>Pirate Paste</h1>

	<div id="content">
		<s:messages />
		<s:errors />
		<s:layout-component name="pageBody"/>
		<s:layout-component name="postRender"/>
	</div>
	</body>
	</html>
</s:layout-definition>