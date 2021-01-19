<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Welcome</title>
	</head>
	<body>
		<h2>Welcome</h2>
		<h3>${message}</h3>
		
		<a href="${pageContext.request.contextPath}/userList">UserList</a>
	</body>
</html>