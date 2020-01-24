<!doctype html>
<html lang="en">
<head>

    <title>registration</title>
</head>
<body>
Add new User
<form action="/registration" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <div>
        <label>First Name: <input type="text" name="firstName"></label>
    </div>
    <div>
        <label>Last Name: <input type="text" name="lastName"></label>
    </div>
    <div>
        <label>Username: <input type="text" name="username"></label>
    </div>
    <div>
        <label>Password: <input type="text" name="password"></label>
    </div>
    <div><input type="submit" value="sing up"></div>
</form>
</body>
</html>