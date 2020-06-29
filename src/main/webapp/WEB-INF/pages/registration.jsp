<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <style>
        body {
            background:url(images/HN9s.jpg); /* Цвет фона и путь к файлу */
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
    <h2   style="color: slategray" align="center"><b>R E G I S T R A T I O N</b></h2>
    <form action="/registration" method="post">
        <p style="color:brown"><strong>${error}</strong></p>
        <p style="color:brown"><strong>${emptyFields}</strong></p>
        <p style="color:brown "><strong>${IncorrectEmail}</strong></p>
        <h4 style="color: slategray"> <strong>N A M E</strong><br>
            <input type="text"  maxlength="25" size="40" name="name"></h4>
        <h4 style="color: slategray"><strong>S U R N A M E</strong><br>
            <input type="text" maxlength="25" size="40" name="surName"></h4>
        <h4 style="color: slategray"> <strong>L O G I N</strong><br>
            <input type="text" maxlength="25" size="40" name="login"></h4>
        <h4 style="color: slategray"><strong>P A S S W O R D</strong><br>
            <input type="password" maxlength="25" size="40" name="password"></h4>
        <h4 style="color: slategray"><strong>E M A I L</strong><br>
            <input type="text" maxlength="25" size="40" name="email"></h4>
        <input type="submit" class="btn btn-primary" value="Submit"  style="width:80pt;height:40px">
    </form>

    <form action="/" method="get">
        <p><input type="submit" class="btn btn-primary" value="Go back"  style="width:80pt;height:40px"></p>
    </form>

</section>
</body>
</html>