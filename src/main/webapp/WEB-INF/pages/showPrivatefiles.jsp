<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Private files</title>
</head>
<body>
<form action="/storage/private-files" method="get">
    <table align="left" border="2">
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
</form>
<p>
<form action="/userPage" method="get">
    <input type="submit" value="Go back">
</form>
</p>
</body>
</html>