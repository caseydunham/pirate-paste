<%@ taglib uri="http://stripes.sourceforge.net/stripes.tld" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<s:layout-render name="Layout.jsp" pageTitle="home">
	<s:layout-component name="pageBody">
		<s:form action="/paste" beanclass="net.caseydunham.pirate.stripes.action.HomeActionBean" id="sharePasteForm">
			<fieldset>
				<legend>Create Paste</legend>
				<input type="text" id="title" name="title" class="input-block-level" placeholder="Title"/>
				<input type="text" id="username" name="username" class="input-block-level" placeholder="Username"/>
				<textarea id="content" name="content" rows="10" cols="50" class="input-block-level" placeholder="Content"></textarea>
				<s:submit name="submit" class="btn btn-primary pull-right" value="Share"/>
			</fieldset>
		</s:form>
	</s:layout-component>
</s:layout-render>