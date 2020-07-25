<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Private files</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <style>
        body {
            background:url(https://photo.boltai.com/wp-content/uploads/sites/11/2015/03/10574395_879134962106182_500743061688271983_n.jpg); /* Цвет фона и путь к файлу */
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
<section>
    <table id="customers" align="left" border="2">
        <tr>
            <td><b>Name</b></td>
            <td><b>Author</b></td>
            <td><b>Genre</b></td>
        </tr>
        <c:forEach items="${musics}" var="music">
            <tr>
                <td>${music.name}</td>
                <td>${music.author}</td>
                <td>${music.genre}</td>
            </tr>
        </c:forEach>
    </table>
    </form>
    <form action="/add-music" method="post">
        <p style="color:brown"><strong>${emptyFields}</strong></p>
        <h2   style="color: slategray" align="center"><b>ADD NEW MUSIC</b></h2>
        <h4 style="color: slategray"> <strong>N A M E</strong><br>
            <input type="text"  maxlength="25" size="40" name="name"></h4>
        <h4 style="color: slategray"><strong>A U T H O  R</strong><br>
            <input type="text" maxlength="25" size="40" name="author"></h4>
        <h4 style="color: slategray"><strong>G E N R E</strong><br>
            <input type="text" maxlength="25" size="40" name="genre"></h4>
        <input type="submit" class="btn btn-primary" value="Add"  style="width:80pt;height:40px">
    </form>
    <form action="/menu" method="get">
        <input type="submit" class="btn btn-primary" value="Go To Menu">
    </form>
    </p>
</section>

</body>
</html>