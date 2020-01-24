<!doctype html>
<html lang="en">
<head>
    
    <title>login</title>
</head>
<body>
<form action="/login" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <div>
        <label>Username: <input type="text" name="username"></label>
    </div>
    <div>
        <label>Password: <input type="text" name="password"></label>
    </div>
    <div><input type="submit" value="sign in"></div>
</form>
</body>
</html>