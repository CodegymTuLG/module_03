<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2022/12/18
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new service</title>
    <link href="/product/css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body>
<div  class="d-flex container-lg">
    <header>
        <h4 class="text-success">Đăng ký mới</h4>
    </header>
    <div class = "row" style="height: 81%">
        <%--Show page add new product--%>
        <div class="col-12"><br>
            <form action="/product?action=createProduct" method="post" class="row g-3" style="width: 95%">
                <label class="form-label">Name:(*)</label>
                <input type="text" class="form-control" name="productName"   required>
                <br>
                <label class="form-label">Price:(*)</label>
                <input type="number" class="form-control" name="price" required>
                <br>
                <label class="form-label">Discount:(*)</label>
                <select name="discount" class="form-select">
                    <option value="5">5%</option>
                    <option value="10">10%</option>
                    <option value="15">15%</option>
                    <option value="20">20%</option>
                </select>
                <br>
                <label class="form-label">Stock:(*)</label>
                <input type="number" class="form-control" name="stock" required>
                <br>
                <div class="col-12 d-flex justify-content-center">
                    <button type="submit" class="btn btn-primary">Thêm</button>
                    <br>

                </div>
            </form>
        </div>
        <div class="justify-content-start">
            <a href="/product"><button  type="button" class="btn-primary">Back</button> </a>
        </div>
    </div>
</div>


<script type="text/javascript" src="/product/js/bootstrap.js"></script>
</body>
</html>
