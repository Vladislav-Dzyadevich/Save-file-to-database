<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <style>
        body {
            background:url(images/HN6s.jpg); /* Цвет фона и путь к файлу */
            margin: 0; /* Убираем отступы */
            height: 100%; /* Высота страницы */
            color: #fff; /* Цвет текста */
            background-size: contain;
        }
    </style>
</head>
<body>
<h1>
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

        <form action="/registration" method="get">
               <input type="submit"  class="btn btn-primary" value= "Registration" style="width:110pt;height:50px">
        </form>
        <form action="/authorization" method="get">
            <input type="submit" class="btn btn-primary" value="Log in"  style="width:110pt;height:50px">
        </form>
    </section>

</h1>
</body>
</html>

