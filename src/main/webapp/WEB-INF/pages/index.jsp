<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload file</title>
</head>
<body>

<form action="/upload" method="get">
    <input type="submit" value="Upload file">
</form>

<form action="/" method="get">
    <table align="left" border="2">
        <tr>
            <td><b>File Name</b></td>
            <td><b>Size</b></td>
            <td><b>Delete</b></td>
        </tr>
        <c:forEach items="${files}" var="file">
            <tr>
                <td>${file.fileName}</td>
                <td>${file.size}</td>
                <td><a href="/delete/${file.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</form>

</body>
</html>