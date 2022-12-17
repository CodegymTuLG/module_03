<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2022/12/17
  Time: 8:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Simple Calculator</h1>
  <form action="/calculator" method="get">
    <label>Fist operand:<input name="fistOperand" type="number"></label><br>
    <label>Operator<select name="operand">
      <option value="+">+</option>
      <option value="-">-</option>
      <option value="*">*</option>
      <option value="/">/</option>
    </select></label><br>
    <label>Second operand:<input name="secondOperand" type="number"></label><br>
    <button type="submit">Caculate</button>
  </form>
  </body>
</html>
