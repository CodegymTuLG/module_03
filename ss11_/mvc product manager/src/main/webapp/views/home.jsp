<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2022/12/14
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            border:1px solid black;
        }
        th{
            border:1px solid black;
            text-align: left;
        }
        td{
            border:1px solid black;
            text-align: left;
        }
    </style>
</head>
<body>
<form action="/home?action=searchByName" method="post">
    <input name="searching" placeholder="search by name"><button type="submit">Search</button>
</form>
<h2>Hiện thị danh sách sản phẩm</h2>
<a href="/home?action=add"><button>add new</button></a><br>
<table class="table table-striped" style="width: 60%;">
    <tr style="text-align: center">
        <th style="width: 15px">STT</th>
        <th style="width: auto">Name</th>
        <th style="width: auto">Marker</th>
        <th style="width: 15px">EDIT</th>
        <th style="width: 15px">DETAIL</th>
        <th style="width: 15px">DELETE</th>
    </tr>
    <c:forEach var="product" items="${productList}" varStatus="status">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.marker}</td>
            <td><a href="/home?action=search&id=${product.id}"><button style="background-color: blue">edit</button></a></td>
            <td><a href="/home?action=detail&id=${product.id}"><button style="background-color: green">detail</button></a></td>
            <td><a href="/home?action=delete&id=${product.id}"><button style="background-color: red">delete</button></a></td>

        </tr>
    </c:forEach>
    <td colspan="14">${message}</td>
</table>

</body>
</html>
