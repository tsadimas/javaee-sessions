<c:set var="contact" value="${sessionScope['Contact']}" />
<form action="<c:url value="/Contact"><c:param name="user_id" value="${User.id}" /></c:url>" method="post">
<label for="name" value="Name: "/>
<input name="name" type="text" value="${contact.name}"/><br/>
<label for="surname" value="Surname: "/>
<input name="surname" type="text" value="${contact.surname}"/><br/>
<label for="phone" value="Phone: "/>
<input name="phone" type="text" value="${contact.phone}"/><br/>
<label for="birthdate" value="Birthdate: "/>
<input name="birthdate" type="text" value="${contact.birthdate}"/><br/>
<label for="id" value="Id: "/>
<input name="id" type="text" value="${contact.id}" readonly /><br/>
<input type="submit" value="Save"/>
</form>