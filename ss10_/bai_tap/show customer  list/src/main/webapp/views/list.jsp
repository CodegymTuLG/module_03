<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2022/12/17
  Time: 7:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        th, td{
            border: 1px black solid;
        }
    </style>
</head>
<body>
<table class="table table-striped" style="width: 60%;">
    <tr style="text-align: center">
        <th>Name</th>
        <th>Birth Day</th>
        <th>Address</th>
        <th>Image</th>
    </tr>
    <c:forEach var="customer" items="${customerList}" varStatus="status">
        <tr>
            <td>${customer.name}</td>
            <td>${customer.birthday}</td>
            <td>${customer.address}</td>
            <td><img src="${customer.imageUrl}"> </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
