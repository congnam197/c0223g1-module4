<%--
  Created by IntelliJ IDEA.
  User: TechCare
  Date: 6/15/2023
  Time: 11:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        fieldset {
            width: 50%;
        }
        h3{
            color: rgba(255, 0, 0, 0.54);
        }
    </style>
</head>
<body>
<center>
    <form action="/convert/calculator" method="post">
        <fieldset>
            <legend>Convert from USD to VND</legend>
            USD <input type="number" id="money" name="money" value="${usd}" placeholder="Enter USD" required>
            Rate :<input type="number" name="rate" placeholder="Enter Rate" value="${rate}" required>
            <input type="submit" value="Convert">
            <h1>VND = ${result}</h1>
            <h3>${error}</h3>
        </fieldset>
    </form>
</center>
</body>
</html>
