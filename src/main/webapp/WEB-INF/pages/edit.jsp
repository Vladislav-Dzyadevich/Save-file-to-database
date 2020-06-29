<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit file</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <style>
        body {
            background:url(https://cdn.wallpapersafari.com/0/39/ab6pCW.jpg); /* Цвет фона и путь к файлу */
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
    <p><b><h2 style="color: darkslateblue">Make changes</h2></b></p>
    <form action="/admin/edit/${fileId}" method="post">
        <input type="text" style="color: darkslateblue" value="${fileName}" name="newFileName">
        <input type="submit" class="btn btn-primary" value="Ok">
    </form>

    <form action="/admin/menu" method="get">
        <p><input type="submit" class="btn btn-primary" value="Go back"></p>
    </form>
</section>


</body>
</html>