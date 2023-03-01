<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2022/12/17
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>HOUSE</title>
    <link href="/product/css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body>
<div  class="d-flex container">
    <header>
        <h4 class="text-success">danh sách sản phẩm</h4>
    </header>
<div class = "row" style="height: 81%">
    <%--List product--%>
    <div class="col-12">
        <p>${message}</p>
        <form action="/product?action=search" method="post">
            <span>danh sách top:</span>
            <select name="recordNum" id="recordNum">
                <option value="3">3</option>
                <option value="5">5</option>
                <option value="10">10</option>
            </select>
            <span>sản phẩm được đặt hàng nhiều nhất</span>
            <button class="btn btn-info" type="submit">Xem</button>
        </form>
        <div class="d-flex justify-content-start" style="width: 90%;">
        <a href="/product?action=create"><button class="btn btn-primary">Thêm mới</button></a><br><br>
        </div>
        <table class="table table-bordered" style="width: 100%;">
            <tr style="text-align: center">
                <th>STT</th>
                <th>Name</th>
                <th>Price</th>
                <th>Discount</th>
                <th>Strock</th>
            </tr>
            <c:forEach var="product" items="${productList}" varStatus="status">
                <tr>
                    <td>${product.getProductId()}</td>
                    <td>${product.getProductName()}</td>
                    <td>${product.getPrice()}</td>
                    <td>${product.getDiscount()}</td>
                    <td>${product.getStock()}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<script type="text/javascript" src="/product/js/bootstrap.js"></script>
</div>
</body>
</html>
