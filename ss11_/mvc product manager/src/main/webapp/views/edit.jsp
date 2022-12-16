<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2022/12/16
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>edit product</h2>
<form method="post" action="/home?action=edit&id=${product.id}">
    <span>edit information</span><br>
    <span>name<input name="name" placeholder="${product.name}"></span><br>
    <span>marker<input name="marker" placeholder="${product.marker}"></span><br>
    <button type="submit">edit</button>
</form>
<a href="/home"><button>back to list</button></a>
</body>
</html>
