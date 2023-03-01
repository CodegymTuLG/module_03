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
    <script src="js/jquery-3.6.3.min.js"></script>
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
    <%--List Customer--%>
    <div class="col-10"> <h1>Accompanied Service</h1>
        <p>${message}</p>
        <!-- Button trigger modal -->
        <div class="d-flex justify-content-end" style="width: 95%;padding-bottom: 10px">
                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addServiceModal">
                Register new contract
                </button>
        </div>
        <table class="table table-info" style="width: 98%;">
            <tr style="text-align: center">
                <th>#</th>
                <th>Service</th>
                <th>Customer</th>
                <th>Start date</th>
                <th>End date</th>
                <th>Deposit</th>
                <th>Payment</th>
                <th colspan="2">Contract</th>
            </tr>
            <c:forEach var="contract" items="${contractList}" varStatus="status">
                <tr>
                    <td>${contract.getContract_id()}</td>
                    <td>${contract.getService().getName()}</td>
                    <td>${contract.getCustomer().getName()}</td>
                    <td>${contract.getStartdate()}</td>
                    <td>${contract.getEnddate()}</td>
                    <td>${contract.getDeposit()}</td>
                    <td>${contract.getPayment()}</td>
                    <td>
                            <!-- Button trigger modal -->
                            <button type="button" onclick="addContractDetail('${contract.getContract_id()}','${customer.getName()}')" class="btn btn-info" data-bs-toggle="modal" data-bs-target="#addModal">
                                +
                            </button>
                    </td>
                    <td>
                        <!-- Button trigger modal -->
                        <form action="/contract?action=contractDetail" method="post">
                        <input type="hidden" name="contract_id" value="${contract.getContract_id()}">
                            <button type="submit" id="submit" class="btn btn-info" data-bs-toggle="modal" data-bs-target="#showlist">
                                Accompanied service list
                            </button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<input type="hidden" value="${flag}" id="flag">
<%--<div class="row" style="height: 5%" >--%>
<%--    <footer class="text-center bg-primary">--%>
<%--        <h1> Footer </h1>--%>
<%--    </footer>--%>
<%--</div>--%>
<!-- Modal add-->
<div class="modal fade" id="addServiceModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Add new service</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <p id="messsage" name="messsage"></p>
            <form action="/contract?action=createContract" method="post">
                <div class="p-4">
                    <div class="mb-3">
                        <label class="form-label">Start date</label>
                        <input type="date" class="form-control" id="startdate" name="startdate" onchange="caculPayment()">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">End date</label>
                        <input type="date" class="form-control" id="enddate" name="enddate" onchange="caculPayment()">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Deposit</label>
                        <input type="number" class="form-control" id="deposit" name="deposit" onchange="caculPayment()">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Payment</label>
                        <input type="number" class="form-control" id="caculResult" disabled>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Employee</label><br>
                        <select name="employee_id" style="height: 38px; width: 450px">
                            <c:forEach var="employee" items="${employeeList}">
                                <option class="form-select" value="${employee.getEmployee_id()}">${employee.getName()}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Customer</label><br>
                        <select name="customer_id" style="height: 38px; width: 450px">
                            <c:forEach var="customer" items="${customerList}">
                                <option class="form-select" value="${customer.getCustomer_id()}">${customer.getName()}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Service</label><br>
                        <select name="service_id" style="height: 38px; width: 450px" id="service_id" onchange="caculPayment()">
                            <c:forEach var="service" items="${serviceList}">
                                <option  class="form-select service_cus" value="${service.getService_id()}" data="${service.getRentprice()}">${service.getName()}</option>
<%--                                <input style="display: none" type="hidden" id="price_${service.getService_id()}" name="price" value="${service.getRentprice()}"/>--%>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Accompanied service</label><br>
                        <select name="addNewService" style="height: 38px" id="addNewService">
                            <c:forEach var="accompaniedservice" items="${accompaniedserviceList}">
                                <option class="form-select addNewService" value="${accompaniedservice.getAccompaniedservice()}" data="${accompaniedservice.getPrice()}" subId="${accompaniedservice.getAccompaniedservice_id()}">${accompaniedservice.getAccompaniedservice()}</option>
                            </c:forEach>
                        </select>
                        <button type="button" class="btn btn-info" onclick="addService()">+</button>
                        <p id="shownew" name="shownew"></p>
                        ----- show table
                        <p id="table" name="table"></p>

                        <input type="hidden" id="subServices" name="subServices">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary" onclick="checkTrueValue()">Register</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- Modal list -->
<div class="modal fade" id="showlist" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" >
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel2">Accompanied service list</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <table class="table table-striped">
                <input type="hidden" value="accompaniedservice" id="accompaniedservice">
                <tr style="text-align: center">
                        <th>Service name</th>
                        <th>Price</th>
                        <th>Unit</th>
                        <th>Count</th>
                    </tr>
                <input type="hidden" name="contractId" id="contractId">
                        <c:forEach var="accompaniedservice" items="${listContractDetail}">
                            <tr>
                                <td>${accompaniedservice.getAccompaniedservice()}</td>
                                <td>${accompaniedservice.getPrice()}</td>
                                <td>${accompaniedservice.getUnit()}</td>
                                <td>${accompaniedservice.getCount()}</td>
                            </tr>
                        </c:forEach>
                </table>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript" src="/views/js/bootstrap.js"></script>
<script>
    $(document).ready(function () {
        let flag = $("#flag").val();
        if(flag == 1){
            $("#showlist").modal("show");
        }
    })

    let listSubService = [];
    let listServicePrice = [];
    let lisSubServiceId = [];
    function addService() {
        let newService = document.getElementById("addNewService").value;
        lisSubServiceId.push(GetSubServiceId(newService));
        listServicePrice.push(GetSubServicePrice(newService));
        listSubService.push(newService);

        /*show table*/
let stringTable = ""
        stringTable += '    <table class=\'table tab-content\'>\n' +
            '        <tr>\n' +
            '            <th>SubService</th>\n' +
            '            <th>Unit</th>\n' +
            '            <th>Price</th>\n' +
            '            <th>Count</th>\n' +
            '        </tr>\n';

            stringTable +=
                '        <tr>\n' +
                '            <td>'+listSubService[0]+'</td>\n' +
                '            <td>Unit</td>\n' +
                '            <td>'+listServicePrice[0]+'</td>\n' +
                '            <td id="count_0" name="count_0">1</td>\n' +
                '        </tr>\n';
        if(listSubService.length>0){
            for (let i = 1; i < listSubService.length; i++) {
                stringTable += '<tr>';
                console.log("listSubService[i]" +listSubService[i] + ", i=" + i)
                console.log("listSubService[i-1]" +listSubService[i-1])
                if(listSubService[i] != listSubService[i-1]){
                    stringTable += '<td>'+listSubService[i]+'</td>';
                    stringTable += '<td></td>';
                    stringTable += '<td>'+listServicePrice[i]+'</td>';
                    stringTable += '<td id="count_'+lisSubServiceId[i]+'" name="count_'+lisSubServiceId[i]+'">1</td>\n';
                }else {
                    let count_id = "count_" + (i-1);
                    console.log(count_id);
                    let count = parseInt(document.getElementById(count_id).innerText)+1;
                    console.log(count);
                    document.getElementById(count_id).innerHTML = ""+count;
                    console.log(count);
                }
            }
        }
        stringTable += '</tr>';
        stringTable +='</table>';
        document.getElementById("table").innerHTML = stringTable;
        /*show table*/


        document.getElementById("shownew").innerText = listSubService;
        document.getElementById("subServices").value = lisSubServiceId;
        caculPayment();
    }
    function caculPayment() {
        let serviceId = document.getElementById("service_id").value;
        let deposit = document.getElementById("deposit").value;
        let sum = 0;
        for(let price of listServicePrice){
            sum += parseInt(price);
        }
            if(GetDays()>0){
                document.getElementById("caculResult").value = GetDays()*GetServicePrice(serviceId) - deposit + sum;
            }
        }
    function GetSubServiceId(id) {
        let subId;
        const els = document.getElementsByClassName("addNewService");
        for (let el of els) {
            if (el.value == id) {
                subId = el.getAttribute('subId');
                return subId;
            }
        }
    }
    function GetSubServicePrice(id) {
        let priceData;
        const els = document.getElementsByClassName("addNewService");
        for (let el of els) {
            if (el.value == id) {
                priceData = el.getAttribute('data');
                return priceData;
            }
        }
    }
    function GetServicePrice(serviceId) {
        let priceData;
        const els = document.getElementsByClassName("service_cus");
        for (let el of els) {
            if (el.value == serviceId) {
                priceData = el.getAttribute('data');
                return priceData;
            }
        }
    }
    function GetDays(){
        var startdate = new Date(document.getElementById("startdate").value);
        var enddate = new Date(document.getElementById("enddate").value);
        var datediff = parseInt((enddate - startdate) / (24 * 3600 * 1000));
        document.getElementById("messsage").innerText  = "";
        if(datediff<0){
            document.getElementById("messsage").innerText  = "let pick another date !";
            document.getElementById("caculResult").value = "";
            return;
        }else if(datediff==0){
            document.getElementById("messsage").innerText  = "";
            return 1;
        }
        return datediff;
    }
    function checkTrueValue(){
        let caculResult = document.getElementById("caculResult").value;
        if(caculResult<0){
            document.getElementById("messsage").innerText = "Payment value is false!";
            alert("Payment value is false!");
        }
    }
</script>

</body>
</html>
