<c:set var="contact" value="${requestScope['Contact']}" />
<form action="<c:url value="/Contact"><c:param name="user_id" value="${User.id}" /></c:url>" method="post">
<label for="name">Name:</label>
<input name="name" type="text" value="${contact.name}"/><br/>
<label for="surname">Surname:</label>
<input name="surname" type="text" value="${contact.surname}"/><br/>
<label for="phone">Phone:</label>
<input name="phone" type="text" value="${contact.phone}"/><br/>
<label for="birthdate">Birthdate:</label>
<input name="birthdate" type="text" value="${contact.birthdate}"/><br/>
<label for="id">Id:</label>
<input name="id" type="text" value="${contact.id}" readonly /><br/>
<input type="submit" value="Save"/>
</form>