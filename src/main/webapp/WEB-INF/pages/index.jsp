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

<form action="/admin/allUsers" method="get">
    <input type="submit" value="All Users">
</form>

<form action="/admin/menu" method="get">
    <input id = "txtSearch" type="text" name="name">
    <button type="submit">Search</button>
</form>

<form action="/admin/menu" method="get">
    <table align="left" border="2">
        <tr>
            <td><b>File Name</b></td>
            <td><b>Size (KB)</b></td>
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
                <td><a href="/admin/edit/${file.id}" type="file">Edit</a></td>
            </tr>
        </c:forEach>
    </table>
</form>
<form action="/logout" method="get">
  <input type="submit" value="Logout">
</form>

</body>
</html>