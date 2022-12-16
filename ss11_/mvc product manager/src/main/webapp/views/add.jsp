<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2022/12/14
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>add new product</h2>
<form method="post" action="/home?action=add">
    <input name="id" placeholder="input id"><br>
    <input name="name" placeholder="input name"><br>
    <input name="marker" placeholder="input marker"><br>
    <button type="submit">Add</button>
</form>
<a href="/home"><button>back to list</button></a>
</body>
</html>
