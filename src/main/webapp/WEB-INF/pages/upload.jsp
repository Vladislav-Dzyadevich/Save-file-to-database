<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload file</title>
</head>
<body>

<form action="/file" method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    <input type="submit" value="Upload">
</form>

<form action="/menu" method="get">
    <input type="submit" value="Go back">
</form>

</body>
</html>