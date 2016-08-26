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