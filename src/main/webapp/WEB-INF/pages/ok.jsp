<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload file</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <style>
        body {
            background:url(https://lh3.googleusercontent.com/proxy/0iBgCfKdO_vqdd6_I79v8zJRckvicfaJtgzIt1cqgBxSENvr7rodueaR3t477OpxBHiFvcYJpSUWqhkseoRbLd47eYOi3xnqP0RHVKhzn2LV); /* Цвет фона и путь к файлу */
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
    <h2 style="color: royalblue">Operation is successful!</h2>
    <img src="<c:url value="/images/HN3s.gif" />" alt="TestDisplay"/>
    <form action="/admin/menu" method="get">
        <input type="submit" class="btn btn-primary" value="Go back">
    </form>
</section>
</body>
</html>