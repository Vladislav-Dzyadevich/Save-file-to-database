<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <style>
        body {
            background:url(https://image.freepik.com/free-photo/high-angle-view-tropical-palm-leaves-isolated-white-background_23-2147837955.jpg); /* Цвет фона и путь к файлу */
            margin: 0; /* Убираем отступы */
            height: 100%; /* Высота страницы */
            color: #fff; /* Цвет текста */
            background-size: cover;
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

<section>
    <form action="/admin/editUserLogin/${userId}" method="post">
        <p><b><h4 style="color: darkslateblue">N A M E</h4></b></p>
        <input type="text" value="${userName}" style="color: darkslateblue" name="newUserName">
        <p><b><h4 style="color: darkslateblue">S U R N A M E</h4></b></p>
        <input type="text" value="${userSurName}" style="color: darkslateblue" name="newUserSurName">
        <p><b><h4 style="color: darkslateblue">L O G I N</h4></b></p>
        <input type="text" value="${userLogin}" style="color: darkslateblue" name="newUserLogin">
        <p><b><h4 style="color: darkslateblue">E M A I L</h4></b></p>
        <input type="text" value="${userEmail}" style="color: darkslateblue" name="newUserEmail">
        <input type="submit" class="btn btn-primary" value="Ok">
        <p style="color: royalblue">${IncorrectEmail}</p>
    </form>

    <form action="/admin/menu" method="get">
        <p><input type="submit" class="btn btn-primary" value="Go back"></p>
    </form>
</section>

</body>
</html>