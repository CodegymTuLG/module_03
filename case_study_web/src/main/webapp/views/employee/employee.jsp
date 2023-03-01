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
    <title>Employee</title>
    <link href="/views/css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body>
<header class="row navbar navbar-expand-lg navbar-light bg-light" style="height: 7%">
    <div class="container-fluid">
        <img src="/views/img/logo.png" style = "height:50px">
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
        <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-5">
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
    <div class="col-2">
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
    <%--List Employee--%>
    <div class="col-10"> <h1>Employee</h1>
       <p>${message}</p>
        <div class="d-flex justify-content-end" style="width: 95%;">
        <a href="/employee?action=create"><button class="btn btn-primary">Register new employee</button></a><br><br>
        </div>
        <table class="table table-info" style="width: 98%;">
            <tr style="text-align: center">
                <th>#</th>
                <th>Employee name</th>
                <th style="width: 100px">Birth day</th>
                <th>Card id</th>
                <th>Salary</th>
                <th>Phone Number</th>
                <th>Email</th>
                <th>Address</th>
                <th>Position</th>
                <th>Level</th>
                <th>Work part</th>
                <th>EDIT</th>
                <th>DELETE</th>
            </tr>
            <c:forEach var="employee" items="${employeeList}" varStatus="status">
                <tr>
                    <td>${employee.getEmployee_id()}</td>
                    <td>${employee.getName()}</td>
                    <td class="text-end">${employee.getBirthday()}</td>
                    <td class="text-end">${employee.getCardid()}</td>
                    <td class="text-center">${employee.getSalary()}</td>
                    <td>${employee.getPhonenumber()}</td>
                    <td>${employee.getEmail()}</td>
                    <td>${employee.getAddress()}</td>
                    <td>${employee.getPositionMaster().getPosition()}</td>
                    <td>${employee.getLevelMaster().getLevel()}</td>
                    <td>${employee.getWorkPartMaster().getWorkpart()}</td>
                    <td>
                        <form action="/employee?action=edit" method="post">
                            <input type="hidden" name="editEmployeeId" id="editEmployeeId" value="${employee.getEmployee_id()}">
                            <button type="submit" class="btn btn-info">Edit</button>
                        </form>
                    </td>
                    <td>
                            <!-- Button trigger modal -->
                            <button type="button" onclick="deleteEmployee('${employee.getEmployee_id()}','${employee.getName()}')" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
                                Delete
                            </button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<%--<div class="row" style="height: 5%" >--%>
<%--    <footer class="text-center bg-primary">--%>
<%--        <h1> Footer </h1>--%>
<%--    </footer>--%>
<%--</div>--%>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="/employee?action=delete" method="post">
                <div class="modal-body">
                    <input readonly type="hidden" name="deleteEmployeeId" id="deleteEmployeeId">
                    <span>Do you really want to delete "</span><span id="deleteName"></span><span></span><span>" ?</span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Delete</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript" src="/views/js/bootstrap.js"></script>
<script>
 function deleteEmployee(id,name) {
     document.getElementById("deleteName").innerText = name;
     document.getElementById("deleteEmployeeId").value = id;
 }
</script>
</body>
</html>
