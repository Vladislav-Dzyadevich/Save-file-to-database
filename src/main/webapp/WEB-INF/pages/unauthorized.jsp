<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>You are missing</title>
</head>
<body>
<form action="/unauthorized" method="get">
    <p>You are missing</p>
    <img src="<c:url value="/images/HN2s.gif" />" alt="TestDisplay"/>
</form>
<form action="/userPage" method="get">
    <input type="submit" value="Go back">
</form>
</body>
</html>