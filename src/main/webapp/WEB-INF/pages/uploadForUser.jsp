<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload file</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <style>
        body {
            background:url(https://i.pinimg.com/originals/40/fb/8f/40fb8fc1806252fe35819302eae69450.jpg); /* Цвет фона и путь к файлу */
            margin: 0; /* Убираем отступы */
            height: 100%; /* Высота страницы */
            color: #fff; /* Цвет текста */
            background-size: inherit;
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
    <form action="/fileForUser" method="post" enctype="multipart/form-data">
        <input type="file"  style="color: black" name="file">
        <br>
            <input type="radio" id="public"  name="status" value="PUBLIC">

            <label for="public"  style="color: black">Public</label>
            <input type="radio" id="private" name="status" value="PRIVATE">

            <label for="private"  style="color: black">Private</label>
            <br><br>
            <input type="submit" class="btn btn-primary" value="Upload">
    </form>

    <form action="/userPage" method="get">
        <input type="submit" class="btn btn-primary" value="Go back">
    </form>

</section>

</body>
</html>