<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<p><b>Регистрация</b></p>
<form action="/registration" method="post">
    <p><strong>Имя:</strong>
        <input type="text"  maxlength="25" size="40" name="name"></p>
    <p><strong>Фамилия:</strong>
        <input type="text" maxlength="25" size="40" name="surName"></p>
    <p><strong>Логин:</strong>
        <input type="text" maxlength="25" size="40" name="login"></p>
    <p><strong>Пароль:</strong>
        <input type="password" maxlength="25" size="40" name="password"></p>
    <p><strong>Почта:</strong>
        <input type="text" maxlength="25" size="40" name="email"></p>
    <input type="submit" value="Submit">
    <p>${error}</p>
    <p>${emptyFields}</p>
    <p>${IncorrectEmail}</p>
</form>

<form action="/" method="get">
    <p><input type="submit" value="Go back"></p>
</form>
</body>
</html>