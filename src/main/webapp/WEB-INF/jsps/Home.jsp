<%@ taglib uri="http://stripes.sourceforge.net/stripes.tld" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<s:layout-render name="Layout.jsp" pageTitle="home">
	<s:layout-component name="pageBody">
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
	</s:layout-component>
</s:layout-render>