<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload file</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <style>
        body {
            background:url(https://i.pinimg.com/originals/fe/33/7b/fe337be38e904f711c1c80c2b4227d88.jpg); /* Цвет фона и путь к файлу */
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
        <form action="/upload" method="get">
            <input type="submit" class="btn btn-primary" value="Upload file" >
        </form>

        <form action="/admin/allUsers" method="get">
            <input type="submit" class="btn btn-primary" value="All users">
        </form>

    <form action="/admin/menu" method="get">
        <input id = "txtSearch"  type="text" style="color: royalblue" name="name">
        <button type="submit" class="btn btn-primary" >Search</button>

        <table class="table table-striped">
            <thead>
            <tr>
                <td width="70px"><b>File Name</b></td>
                <td width="70px"><b>Size (KB)</b></td>
                <td width="70px"><b>Delete</b></td>
                <td width="80px"><b>Download</b></td>
                <td width="60px"><b>Edit</b></td>
            </tr>
            </thead>
            <c:forEach items="${files}" var="file">
                <tr>
                    <td>${file.fileName}</td>
                    <td>${file.size}</td>
                    <td><a href="/delete/${file.id}">Delete</a></td>
                    <td><a href="/download/${file.id}" type="file">Download</a></td>
                    <td><a href="/admin/edit/${file.id}" type="file">Edit</a></td>
                </tr>
            </c:forEach>
        </table>

        <nav aria-label="Page navigation">
        <ul class="pagination">
            <c:if test="${allPages ne null}">
                <c:forEach var="i" begin="1" end="${allPages}">
                    <li><a href="/admin/menu?page=<c:out value="${i - 1}"/>&name=${name}"><c:out value="${i}"/></a></li>
                </c:forEach>
            </c:if>
        </ul>
    </nav>
    </form>

    <form action="/logout" method="get">
        <input type="submit" class="btn btn-primary" value="Logout">
    </form>
</section>


</body>
</html>