<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All files</title>
</head>

<body>
File count is ${allFiles}
<form action="/show" method="get">
</form>
<form action="/admin/menu" method="get">
    <input type="submit" value="Go back">
</form>
</body>
</html>