<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://stripes.sourceforge.net/stripes.tld" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<body>
<h1>Pirate Paste</h1>

<h3>Viewing Paste</h3>
<ul>
	<li>${actionBean.paste.title}</li>
	<li>${actionBean.paste.username}</li>
	<li>${actionBean.paste.content}</li>
</ul>

</body>

</html>