<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>All Employees</title>
</head>
<body>
	<div align="center">
		<H3 style="color: green">WELCOME TO STUDENT DATA PAGE</H3>
		<table border="1">
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>FEE</th>
				<th colspan="2">LINK</th>
			</tr>
			<c:forEach items="${list}" var="ob">
				<tr>
					<td>${ob.stdId}</td>
					<td>${ob.stdName}</td>
					<td>${ob.stdFee}</td>
					<td><a href="delete?id=${ob.stdId}">DELETE</a></td>
					<td><a href="edit?id=${ob.stdId}">EDIT</a></td>
				</tr>
			</c:forEach>
		</table>
		<br />
		<h1 style="color: red; text-align: center">
			<a href="index.jsp"> Home</a>
		</h1>
		${message}
	</div>
</body>
</html>
