<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://stripes.sourceforge.net/stripes.tld" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<s:layout-definition>
	<!DOCTYPE html>
	<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<title>Pirate Paste</title>
		<base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">

		<link href="/styles/bootstrap.css" rel="stylesheet">
		<style type="text/css">
			body {
				padding-top: 60px;
				padding-bottom: 40px;
			}
			.sidebar-nav {
				padding: 9px 0;
			}
		</style>
	</head>

	<body>
		<div class="navbar navbar-inverse navbar-fixed-top">
			<div class="navbar-inner">
				<div class="container-fluid">
					<a class="brand" href="/home">Pirate Paste</a>
					<div class="nav-collapse collapse">
						<ul class="nav">
							<li><s:link beanclass="net.caseydunham.pirate.stripes.action.HomeActionBean">Create</s:link></li>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span3">
					<div class="well sidebar-nav">
						<ul class="nav nav-list">
							<li class="nav-header">Recent Pastes</li>
							<c:forEach var="paste" items="${actionBean.recentPastes}">
								<li><a href="/pastes/${paste.id}"><c:out value="${paste.title}"/></a> by <c:out value="${paste.username}"/></li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<div class="span9">
					<div class="row-fluid">
						<div class="span6">
							<s:messages />
							<s:layout-component name="pageBody"/>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
	</html>
</s:layout-definition>