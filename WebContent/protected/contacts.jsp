<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contacts Page</title>
</head>
<body>
	<c:set var="contacts" value="${sessionScope['Contacts']}" />
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Surname</th>
				<th>Phone</th>
				<th>Birthdate</th>
				<th>user_id</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${contacts}" var="contact">
				<tr>
					<td><c:out value="${contact.id}" /></td>
					<td><c:out value="${contact.name}" /></td>
					<td><c:out value="${contact.surname}" /></td>
					<td><c:out value="${contact.phone}" /></td>
					<td><c:out value="${contact.birthdate}" /></td>
					<td><c:out value="${contact.user_id}" /></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
</body>
</html>