<!DOCTYPE HTML>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>User List</title>
<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<header>
			<h2>Spring Boot + SpringMVC + Spring Data JPA + JSP</h2>
		</header>
		<div class="starter-template">
			<strong><a href="${pageContext.request.contextPath }/index">Home</a></strong>
			<h3>Users List</h3>
			<table
				class="table table-striped table-hover table-condensed table-bordered">
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Email</th>
				</tr>
				<c:forEach items="${allUsers}" var="user">
					<tr>
						<td>${user.id}</td>
						<td>${user.name}</td>
						<td>${user.email }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
