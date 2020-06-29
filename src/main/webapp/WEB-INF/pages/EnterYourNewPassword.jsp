<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Enter your new password</title>
    <title>Upload file</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <style>
        body {
            background:url(https://i.pinimg.com/originals/a0/a3/50/a0a35084dbb8fd99a6ecf957f8620d08.png); /* Цвет фона и путь к файлу */
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
<section>
    <form action="/reset-password" method="post">
        <p><h2 style="color: darkblue">Enter your new password</h2></p>
        <P><input type="password" style="color: darkblue"name="newPassword"></P>
        <br>
        <input type="text " value="${email}" style="color: darkblue" name="email">
        <input type="submit" class="btn btn-primary" value="ok">
    </form>
</section>


</body>
</html>
