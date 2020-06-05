<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload file</title>
</head>
<body>
<form action="/show" method="get">
    <input type="submit" value="show files">
</form>

<form action="/upload" method="get">
    <input type="submit" value="Upload file">
</form>

<form action="/allUsers" method="get">
    <input type="submit" value="All Users">
</form>

<form action="/registration" method="get">
    <input type="submit" value="Registration">
</form>

<form action="/" method="get">
    <table align="left" border="2">
        <tr>
            <td><b>File Name</b></td>
            <td><b>Size mb</b></td>
            <td><b>Delete</b></td>
            <td><b>Download</b></td>
            <td><b>Edit</b></td>
        </tr>
        <c:forEach items="${files}" var="file">
            <tr>
                <td>${file.fileName}</td>
                <td>${file.size}</td>
                <td><a href="/delete/${file.id}">Delete</a></td>
                <td><a href="/download/${file.id}" type="file">Download</a></td>
                <td><a href="/edit/${file.id}" type="file">Edit</a></td>
            </tr>
        </c:forEach>
    </table>
</form>


</body>
</html>