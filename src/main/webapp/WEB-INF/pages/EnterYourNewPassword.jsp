<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Enter your new password</title>
</head>
<body>
<form action="/reset-password" method="post">
    <p>Enter your new password: </p>
    <input type="password" name="newPassword">
    <br>
    <input type="text" value="${email}" name="email">
    <input type="submit" value="ok">
</form>

</body>
</html>
