<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://stripes.sourceforge.net/stripes.tld" prefix="s" %>

<!DOCTYPE html>
<html>

	<body>
		<h1>Pirate Paste</h1>

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