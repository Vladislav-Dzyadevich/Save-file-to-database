<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload file</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <style>
        body {
            background:url(https://i.pinimg.com/originals/04/cd/2d/04cd2da2ad0bfe87cab1f7c40f9954fa.jpg); /* Цвет фона и путь к файлу */
            margin: 0; /* Убираем отступы */
            height: 100%; /* Высота страницы */
            color: #4CAF50; /* Цвет текста */
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

    <h2  style="color: darkred">
        Message was sent to your mail to recover the password</h2>
    <form action="/admin/menu" method="get">
        <input type="submit" class="btn btn-primary" value="Go back">
    </form>
</section>
</body>
</html>