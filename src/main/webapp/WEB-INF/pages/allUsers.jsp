<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All users</title>
</head>
<body>
<form action="/admin/allUsers" method="get">

    <p>Please select your preferred contact method:</p>
    <div>
        <input id = "txtSearch" type="text" name="name">

        <input type="radio" id="contactChoice1"
               name="contact" value="email">
        <label for="contactChoice1">Name</label>
        <input type="radio" id="contactChoice2"
               name="contact" value="phone">
        <label for="contactChoice2">Surname</label>
        <input type="radio" id="contactChoice3"
               name="contact" value="mail">
        <label for="contactChoice3">Login</label>
    </div>
    <div>
       <p><button type="submit">Search</button></p>
    </div>

</form>

<form action="/admin/allUsers" method="get">
    <table align="left" border="2">
        <tr>
            <td><b>User Name</b></td>
            <td><b>User SurName</b></td>
            <td><b>User Email</b></td>
            <td><b>User Login</b></td>
            <td><b>User Password</b></td>
            <td><b>User Role</b></td>
            <td><b>Delete</b></td>
            <td><b>Edit</b></td>

        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.name}</td>
                <td>${user.surName}</td>
                <td>${user.email}</td>
                <td>${user.login}</td>
                <td>${user.password}</td>
                <td>${user.role}</td>
                <td><a href="/admin/deleteUser/${user.id}">Delete</a></td>
                <td><a href="/admin/editUserLogin/${user.id}" type="user">Edit</a></td>
            </tr>
        </c:forEach>
    </table>

</form>

<form action="/admin/menu" method="get">
    <input type="submit" value="Go back">
</form>
</body>
</html>