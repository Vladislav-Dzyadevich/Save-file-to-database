<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User Login</title>
</head>
<body>
<form action="/editUserLogin/${userId}" method="post">
    <p><b>Введите новое имя</b></p>
    <input type="text" value="${userName}" name="newUserName">
   <p><b>Введите новую фамилию</b></p>
    <input type="text" value="${userSurName}" name="newUserSurName">
    <p><b>Введите новый логин</b></p>
    <input type="text" value="${userLogin}" name="newUserLogin">
    <p><b>Введите новый пароль</b></p>
    <input type="text" value="${userPassword}" name="newUserPassword">
    <input type="submit" value="Ok">
</form>

<form action="/menu" method="get">
    <p><input type="submit" value="Go back"></p>
</form>
</body>
</html>