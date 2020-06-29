<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorization</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <style>
        body {
            background:url(images/HN8s.jpg); /* Цвет фона и путь к файлу */
            margin: 0; /* Убираем отступы */
            height: 100%; /* Высота страницы */
            color: #fff; /* Цвет текста */
            background-size: contain;
        }
    </style>
</head>
<c:url value="/authorization" var="loginUrl" />
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
    .b1 {
        background: darkgoldenrod;
        color: white;
        font-size: 9pt;
        text-decoration: none;
        padding: .8em 1em calc(.8em + 3px);
        border-radius: 3px;
        background: rgb(64,199,129);
        box-shadow: 0 -3px rgb(53,167,110) inset;
        transition: 0.2s;

    b1:hover { background: rgb(53, 167, 110); }
    b1:active {
        background: rgb(33,147,90);
        box-shadow: 0 3px rgb(33,147,90) inset;
    }
</style>
<section>
    <form action="${loginUrl}" method="POST">

        <h3 style="color: royalblue"><b> L O G I N</b></h3>
        <input type="text" style="color: royalblue" name="login">
        <h3 style="color: royalblue"><b>P A S S W O R D</b></h3>
        <input type="password" style="color: royalblue" name="password">
        <input type="submit" class="btn btn-primary" value="Ok">
        <c:if test="${param.error ne null}">
            <p style="color: brown"><strong>Wrong login or password!</strong></p>
        </c:if>
    </form>

    <form action="/registration" method="get">
        <input type="submit" class="btn btn-primary" value="Registration" >
    </form>
    <form action="/send-mail/reset-password" method="get">
        <input type = "submit" class="btn btn-primary" value="Forgot password">
    </form>


    <form action="/" method="get">
        <input type="submit" class="btn btn-primary" value="Go back">
    </form>
</section>

</body>
</html>