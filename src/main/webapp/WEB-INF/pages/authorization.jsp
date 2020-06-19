<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorization</title>
</head>
<body>
<c:url value="/authorization" var="loginUrl" />

<form action="${loginUrl}" method="POST">

    <p><b>Введите Логин</b></p>
    <input type="text"  name="login">
    <p><b>Введите Пароль</b></p>
    <input type="password"  name="password">
    <input type="submit" value="Ok">
    <c:if test="${param.error ne null}">
        <p>Wrong login or password!</p>
    </c:if>
</form>

<form action="/registration" method="get">
    <input type="submit" value="Registration">
</form>
<form action="/send-mail/reset-password" method="get">
    <input type = "submit" value="Forgot password">
</form>


<form action="/" method="get">
    <input type="submit" value="Go back">
</form>
</body>
</html>