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
				<ul>
					<li>${actionBean.paste.title}</li>
					<li>${actionBean.paste.username}</li>
					<li>${actionBean.paste.content}</li>
				</ul>
			</c:otherwise>
		</c:choose>
	</s:layout-component>
</s:layout-render>