<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All files</title>
</head>

<body style=" color:lavenderblush; background-color:#c7b39b">
<p style="color:#ffffff"></p>
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
    .b1 {
        background: darkgoldenrod;
        color: white;
        font-size: 8pt;
        text-decoration: none;
        padding: .8em 1em calc(.8em + 3px);
        border-radius: 3px;
        background: rgb(64,199,129);
        box-shadow: 0 -3px rgb(53,167,110) inset;
        transition: 0.2s;
    b1:hover { background: rgb(53, 167, 110); }
    b1:active {
        background: rgb(33,147,90);
        box-shadow: 0 3px rgb(33,147,90) inset;
    }
</style>
<section>
    <h2>File count is ${allFiles}</h2>
    <form action="/show" method="get">
    </form>
    <form action="/admin/menu" method="get">
        <input type="submit" class="b1" value="Go back">
    </form>
</section>

</body>
</html>