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
		<input type="submit" id="${contact.id}" name="deleteContact" value="Delete">
		</c:if>
		</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
	<a href="<c:url value="/protected/contact.jsp"></c:url>"> Add new Contact </a>
	<script type="text/javascript">
	$("[name='deleteContact']").click(function () {
		var urlCall="<c:url value="/Contact"></c:url>"
	alert("Clicked! " + $(this).attr('id'));	
	$.ajax({
	    url: urlCall + '?' + $.param({"contact_id": $(this).attr('id'), "user_id": '${User.id}' }),
	    type: 'DELETE',
	    success: function(result){
	         console.log(result);
	         $(location).attr("href", "<c:url value="/Contacts"></c:url>");
	        },
	    error:  function(result){
	          console.log(result);
        },   
	});
	});
	</script>
</body>
</html>