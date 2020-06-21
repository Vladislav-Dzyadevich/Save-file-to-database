<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload file</title>
</head>
<body>

<form action="/file" method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    <p>
        <input type="radio" id="public" name="status" value="PUBLIC">
        <label for="public">Public</label><br>
        <input type="radio" id="private" name="status" value="PRIVATE">
        <label for="private">Private</label>
        <input type="submit" value="Upload"></form>

<form action="/admin/menu" method="get">
    <input type="submit" value="Go back">
</form>

</body>
</html>