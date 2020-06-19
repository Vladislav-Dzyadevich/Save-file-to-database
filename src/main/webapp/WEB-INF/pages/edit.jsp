<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit file</title>
</head>
<body>
<p><b>Сделайте изменения</b></p>
<form action="/admin/edit/${fileId}" method="post">
    <input type="text" value="${fileName}" name="newFileName">
    <input type="submit" value="Ok">
</form>

<form action="/admin/menu" method="get">
    <p><input type="submit" value="Go back"></p>
</form>

</body>
</html>