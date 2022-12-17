<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2022/12/17
  Time: 8:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Simple Calculator</h1>
<form action="/calculator" method="get">
    <label>Fist operand:<input name="fistOperand"></label><br>
    <label>Operator<select>
        <option>+</option>
        <option>-</option>
        <option>*</option>
        <option>/</option>
    </select></label><br>
    <label>Second operand:<input name="secondOperand"></label><br>
    <button type="submit">Caculate</button>
</form>
</body>
</html>
