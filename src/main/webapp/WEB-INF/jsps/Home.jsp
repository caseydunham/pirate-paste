<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://stripes.sourceforge.net/stripes.tld" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

	<body>
		<h1>Pirate Paste</h1>

		<h3>Recent Pastes</h3>
		<ul>
			<c:forEach var="paste" items="${actionBean.recentPastes}">
	    	<li>${paste.title} - ${paste.username}</li>
			</c:forEach>
		</ul>

		<s:form action="/paste" beanclass="net.caseydunham.pirate.stripes.action.HomeActionBean" id="sharePasteForm">
			<table>
				<tr>
					<td>Title</td>
					<td><s:text name="title"/></td>
				</tr>
				<tr>
					<td>Username</td>
					<td><s:text name="username"/></td>
				</tr>
				<tr>
					<td>Content</td>
					<td><s:textarea name="content" cols="50" rows="10"/></td>
				</tr>
				<tr>
					<td><s:submit value="Share" class="button" name="submit"/></td>
				</tr>
			</table>
		</s:form>

	</body>

</html>