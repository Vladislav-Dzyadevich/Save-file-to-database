<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Enter your email</title>
</head>
<body>
<form action="/send-mail/reset-password" method="post">
    <p>Введите вашу почту</p>
    <input type="text" value="${email}" name="email">
    <input type="submit" value="Ok">
    <p>${emailFail}</p>
</form>

</body>
</html>
