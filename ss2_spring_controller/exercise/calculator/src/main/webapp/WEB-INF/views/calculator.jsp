<%--
  Created by IntelliJ IDEA.
  User: TechCare
  Date: 6/16/2023
  Time: 12:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
    <style>
        body {
            justify-content: center;
            text-align: center;
        }

        .body {
            width: 70%;
            border: 1px solid black;
        }

        .content input {
            height: 40px;
            width: 200px;
            margin: 0 20px 10px 0;
        }

        .content .action button {
            height: 40px;
            width: 120px;
            margin: 10px 8px 20px;
        }
    </style>
</head>
<body>
<div class="body">
    <div class="title">
        <h1>Calculator</h1>
    </div>
    <div class="content">
        <form action="/calculator" method="post">
            <div>
                <input type="number" name="operator1" value="${operator1}" placeholder="operator 1" required>
                <input type="number" name="operator2" value="${operator2}" placeholder="operator 2" required>
            </div>
            <div class="action">
                <button type="submit" name="calculator" value="addition">Addition(+)</button>
                <button type="submit" name="calculator" value="subtraction">Subtraction(-)</button>
                <button type="submit" name="calculator" value="multiplication">Multiplication(X)</button>
                <button type="submit" name="calculator" value="division">Division(/)</button>
            </div>
        </form>
        <h2>Result = ${result}</h2>
    </div>
</div>
</body>
</html>
