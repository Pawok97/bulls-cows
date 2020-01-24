<h1>Hello , ${user.firstName}</h1>
<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="sing out">
</form>