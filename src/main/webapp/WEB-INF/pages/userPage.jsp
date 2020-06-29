<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Menu</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <style>
        body {
            background:url(https://i.pinimg.com/originals/12/eb/59/12eb59390510c8bbf06a4ea5ca6600af.jpg); /* Цвет фона и путь к файлу */
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
    <form action="/uploadForUser" method="get">
        <input type="submit"class="btn btn-primary" value="Upload file">
    </form>
    <form action="/storage/private-files" method="get">
        <input type="submit" class="btn btn-primary" value="Show my private files">
    </form>
    <form action="/logout" method="get">
        <input type="submit" class="btn btn-primary" value="Logout">
    </form>
    <form action="/userPage" method="get">
        <input id = "txtSearch"  type="text" style="color: royalblue" name="name">
        <button type="submit" class="btn btn-primary" >Search</button>
        <table id="customers" align="left" border="2">
            <tr>
                <td><b>File Name</b></td>
                <td><b>Size (KB)</b></td>
                <td><b>Download</b></td>
            </tr>
            <c:forEach items="${files}" var="file">
                <tr>
                    <td>${file.fileName}</td>
                    <td>${file.size}</td>
                    <td><a href="/download/${file.id}" type="file">Download</a></td>
                </tr>
            </c:forEach>
        </table>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${allPages ne null}">
                    <c:forEach var="i" begin="1" end="${allPages}">
                        <li><a href="/userPage?page=<c:out value="${i - 1}"/>&name=${name}"><c:out value="${i}"/></a></li>
                    </c:forEach>
                </c:if>
            </ul>
        </nav>
    </form>

</section>

</body>
</html>