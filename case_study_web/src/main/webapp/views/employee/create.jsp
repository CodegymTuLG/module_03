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
    <link href="./css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body>
<header class="row navbar navbar-expand-lg navbar-light bg-light" style="height: 7%">
    <div class="container-fluid">
        <img src="img/logo.png" style = "height:50px">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <h4 class="text-success">FURAMA RESORT</h4>
                </li>
            </ul>
            <ul class="nav justify-content-end">
                <li class="nav-item">
                    <h5>User Name</h5>
                </li>
            </ul>
        </div>
    </div>
</header>
<nav class="row navbar navbar-expand-lg navbar-light bg-info" style="height: 7%">
    <div class="container-fluid">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
                <a class="navbar-brand" href="/views/home.jsp">Home</a>
            </li>
            <li class="nav-item">
                <a class="navbar-brand" href="/employee">Employee</a>
            </li>
            <li class="nav-item">
                <a class="navbar-brand" href="/customer">Customer</a>
            </li>
            <li class="nav-item">
                <a class="navbar-brand" href="/service">Service</a>
            </li>
            <li class="nav-item">
                <a class="navbar-brand" href="/contract">Contract</a>
            </li>
        </ul>
        <form class="d-flex mt-3">
            <span class="bg-light ct-search-icon">
              <div class="mt-2">
                <svg fill="currentColor" viewBox="0 0 16 16" width="1em" height="1em" class="x1lliihq x1k90msu x2h7rmj x1qfuztq xcza8v6 xlup9mm x1kky2od">
                <g fill-rule="evenodd" transform="translate(-448 -544)">
                  <g fill-rule="nonzero">
                  <path d="M10.743 2.257a6 6 0 1 1-8.485 8.486 6 6 0 0 1 8.485-8.486zm-1.06 1.06a4.5 4.5 0 1 0-6.365 6.364 4.5 4.5 0 0 0 6.364-6.363z" transform="translate(448 544)"></path>
                    <path d="M10.39 8.75a2.94 2.94 0 0 0-.199.432c-.155.417-.23.849-.172 1.284.055.415.232.794.54 1.103a.75.75 0 0 0 1.112-1.004l-.051-.057a.39.39 0 0 1-.114-.24c-.021-.155.014-.356.09-.563.031-.081.06-.145.08-.182l.012-.022a.75.75 0 1 0-1.299-.752z" transform="translate(448 544)">
                    </path>
                    <path d="M9.557 11.659c.038-.018.09-.04.15-.064.207-.077.408-.112.562-.092.08.01.143.034.198.077l.041.036a.75.75 0 0 0 1.06-1.06 1.881 1.881 0 0 0-1.103-.54c-.435-.058-.867.018-1.284.175-.189.07-.336.143-.433.2a.75.75 0 0 0 .624 1.356l.066-.027.12-.061z" transform="translate(448 544)"></path>
                    <path d="m13.463 15.142-.04-.044-3.574-4.192c-.599-.703.355-1.656 1.058-1.057l4.191 3.574.044.04c.058.059.122.137.182.24.249.425.249.96-.154 1.41l-.057.057c-.45.403-.986.403-1.411.154a1.182 1.182 0 0 1-.24-.182zm.617-.616.444-.444a.31.31 0 0 0-.063-.052c-.093-.055-.263-.055-.35.024l.208.232.207-.206.006.007-.22.257-.026-.024.033-.034.025.027-.257.22-.007-.007zm-.027-.415c-.078.088-.078.257-.023.35a.31.31 0 0 0 .051.063l.205-.204-.233-.209z" transform="translate(448 544)"></path>
                  </g>
                </g>
              </svg>
              </div>
            </span>
            <input class="form-control me-2 bg-light border-light ct-search-textbox"
                   type="search" placeholder="Search" aria-label="Search">
        </form>
    </div>

</nav>
<div class = "row" style="height: 81%">
    <div class="col-3">
        <ul class="list-group vh-79 left-nav-scroll">
            <li class="list-group-item">An item</li>
            <li class="list-group-item">A second item</li>
            <li class="list-group-item">A third item</li>
            <li class="list-group-item">A fourth item</li>
            <li class="list-group-item">And a fifth one</li>
            <li class="list-group-item">An item</li>
            <li class="list-group-item">A second item</li>
            <li class="list-group-item">A third item</li>
            <li class="list-group-item">A fourth item</li>
            <li class="list-group-item">And a fifth one</li>
            <li class="list-group-item">An item</li>
            <li class="list-group-item">A second item</li>
            <li class="list-group-item">A third item</li>
            <li class="list-group-item">A fourth item</li>
            <li class="list-group-item">And a fifth one</li>
            <li class="list-group-item">An item</li>
            <li class="list-group-item">A second item</li>
            <li class="list-group-item">A third item</li>
            <li class="list-group-item">A fourth item</li>
            <li class="list-group-item">And a fifth one</li>
            <li class="list-group-item">An item</li>
            <li class="list-group-item">A second item</li>
            <li class="list-group-item">A third item</li>
            <li class="list-group-item">A fourth item</li>
            <li class="list-group-item">And a fifth one</li>
            <li class="list-group-item">An item</li>
            <li class="list-group-item">A second item</li>
            <li class="list-group-item">A third item</li>
            <li class="list-group-item">A fourth item</li>
            <li class="list-group-item">And a fifth one</li>
            <li class="list-group-item">An item</li>
            <li class="list-group-item">A second item</li>
            <li class="list-group-item">A third item</li>
            <li class="list-group-item">A fourth item</li>
            <li class="list-group-item">And a fifth one</li>
        </ul>
    </div>
<%--Show page add new service--%>
<div class="col-9"> <h1>CREATE NEW SERVICE</h1><br>
    <form action="/service?action=create" method="post" class="row g-3" style="width: 95%">
        <div class="col-md-6">
            <label class="form-label">Service name</label>
            <input type="text" class="form-control" name="name">
        </div>
        <div class="col-md-2">
            <label class="form-label">Area</label>
            <input type="number" class="form-control" name="area">
        </div>
        <div class="col-md-4">
            <label class="form-label">Rent Price</label>
            <input type="number" class="form-control" name="rentprice">
        </div>

        <div class="col-md-3">
            <label class="form-label">Person limit</label>
            <input type="number" class="form-control" name="maxperson">
        </div>
        <div class="col-md-3">
            <label class="form-label">Rent Type</label>
            <select name="renttype_id" class="form-select">
                <c:forEach var="rentTypeMaster" items="${rentTypeMasterList}" varStatus="status">
                    <option value="${rentTypeMaster.renttype_id}">${rentTypeMaster.type}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-md-3">
            <label class="form-label">Service Type</label>
            <select name="servicetype_id" class="form-select">
                <c:forEach var="serviceTypeMaster" items="${serviceTypeMasterList}" varStatus="status">
                    <option value="${serviceTypeMaster.servicetype_id}">${serviceTypeMaster.type}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-md-3">
            <label class="form-label">Standard</label>
            <input type="text" class="form-control" name="standar">
        </div>

        <div class="col-md-6">
            <label class="form-label">Other service description</label>
            <input type="text" class="form-control" name="other_service_description">
        </div>
        <div class="col-md-3">
            <label class="form-label">Pool area</label>
            <input type="number" class="form-control" name="pool_area">
        </div>
        <div class="col-md-3">
            <label class="form-label">Floor</label>
            <input type="number" class="form-control" name="floor">
        </div>

        <div class="col-md-12">
            <label class="form-label">Free service</label>
            <input type="text" class="form-control" name="free_service">
        </div>

        <div class="col-12 d-flex justify-content-end">
            <button type="submit" class="btn btn-primary">Create</button>
        </div>
    </form>
</div>
</div>
<div class="row" style="height: 5%" >
    <footer class="text-center bg-primary">
        <h1> Footer </h1>
    </footer>
</div>
<script type="text/javascript" src="./js/bootstrap.js"></script>
</body>
</html>
