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
				<th>Action</th>
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
					<td>
					<c:if test="${User.id == contact.user_id}"> 
					<a href="<c:url value="/Contact"> 
		<c:param name="contact_id" value="${contact.id}" />
		<c:param name="user_id" value="${User.id}" />
		</c:url>">Edit</a>
		</c:if>
		</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
</body>
</html>