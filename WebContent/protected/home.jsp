	<c:set var="currentUser" value="${sessionScope['User']}" />

	<h3>Hi ${currentUser.name}</h3>
	<strong>Your Email</strong>: ${currentUser.email}
	<br>
	<strong>Your Country</strong>: ${currentUser.country}
	<br>
	<strong>Your Id</strong>: ${currentUser.id}
	<br>
	<br>
	
</body>
</html>