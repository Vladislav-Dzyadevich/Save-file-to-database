<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All users</title>
</head>
<body>
<form action="/allUsers" method="get">
    <table align="left" border="2">
        <tr>
            <td><b>User Name</b></td>
            <td><b>User SurName</b></td>
            <td><b>User Login</b></td>
            <td><b>User Password</b></td>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.name}</td>
                <td>${user.surName}</td>
                <td>${user.login}</td>
                <td>${user.password}</td>
            </tr>
        </c:forEach>
    </table>

</form>

<form action="/" method="get">
    <input type="submit" value="Go back">
</form>
</body>
</html>