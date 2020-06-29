<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Enter your email</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <style>
        body {
            background:url(https://i.pinimg.com/originals/96/96/4e/96964e4a6b591f7b199e6a595af60f07.jpg); /* Цвет фона и путь к файлу */
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
    <form action="/send-mail/reset-password" method="post">
        <br><br><br><br><br><br><br>
        <p style="color: darkblue"><strong>Enter your email</strong></p>
        <input type="text" style="color: royalblue" value="${email}" name="email">
        <input type="submit" class="btn btn-primary" value="Ok">
        <p style="color: brown"><strong>${emailFail}</strong></p>
    </form>
    <form action="/authorization" method="get">
        <input type="submit" class="btn btn-primary" value="Go back">
    </form>
</section>
</body>
</html>
