<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All users</title>
    <title>Enter your email</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <style>
        body {
            background:url(https://i.pinimg.com/736x/f3/43/67/f3436711dca521260759f5528154790b.jpg); /* Цвет фона и путь к файлу */
            margin: 0; /* Убираем отступы */
            height: 100%; /* Высота страницы */
            color: #fff; /* Цвет текста */
            background-size: contain;
        }
    </style>
</head>
<body>
<style>
    section {
        border-radius: 1em;
        padding: 1em;
        position: absolute;
        top: 50%;
        left: 50%;
        margin-right: -50%;
        transform: translate(-50%, -50%) }
</style>
<style>
    table {
        font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
        font-size: 14px;
        border-collapse: collapse;
        text-align: center;
    }
    th, td:first-child {
        background: #AFCDE7;
        color: white;
        padding: 10px 20px;
    }
    th, td {
        border-style: solid;
        border-width: 0 2px 2px 0;
        border-color: white;
    }
    td {
        background: #D8E6F3;

    }
    th:first-child, td:first-child {
        text-align: left;
    }
</style>

<style>
    #customers {
        font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
        border-collapse: separate;
        width: 100%;
    }

    #customers td, #customers th {
        border: 1px solid #ddd;
        padding: 4px;
    }

    #customers tr:nth-child(even){background-color: #4CAF50;}

    #customers tr:hover {background-color: #c7b39b;}

    #customers th {
        padding-top: 10px;
        padding-bottom: 10px;
        text-align: left;
        background-color: #4CAF50;
        color: green;
    }
</style>
<section>
    <form action="/admin/allUsers" method="get">

        <p><h2 style="color: darkslateblue">Please select your preferred contact method:</h2></p>
        <div>
            <input id = "txtSearch" style="color: darkslateblue" type="text" name="name">

            <input type="radio" id="contactChoice1"
                   name="contact" value="email">
            <label for="contactChoice1"  style="color: black">Name</label>
            <input type="radio" id="contactChoice2"
                   name="contact" value="phone">
            <label for="contactChoice2"  style="color: black">Surname</label>
            <input type="radio" id="contactChoice3"
                   name="contact" value="mail">
            <label for="contactChoice3"  style="color: black">Login</label>
        </div>
        <div>
            <p><button type="submit" class="btn btn-primary">Search</button></p>
        </div>

    </form>

    <form action="/admin/allUsers" method="get">
        <table id="customers" align="left" border="2">
            <tr>
                <td><b>User Name</b></td>
                <td><b>User SurName</b></td>
                <td><b>User Email</b></td>
                <td><b>User Login</b></td>
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
                    <td>${user.role}</td>
                    <td><a href="/admin/deleteUser/${user.id}">Delete</a></td>
                    <td><a href="/admin/editUserLogin/${user.id}" type="user">Edit</a></td>
                </tr>
            </c:forEach>
        </table>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${allPages ne null}">
                    <c:forEach var="i" begin="1" end="${allPages}">
                        <li><a href="/admin/allUsers?page=<c:out value="${i - 1}"/>&name=${name}"><c:out value="${i}"/></a></li>
                    </c:forEach>
                </c:if>
            </ul>
        </nav>
    </form>

    <form action="/admin/menu" method="get">
         <input type="submit" class="btn btn-primary" value="Go back">
    </form>
</section>

</body>
</html>