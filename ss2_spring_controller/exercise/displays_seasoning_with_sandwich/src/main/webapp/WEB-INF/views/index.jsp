<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<body>
<center style="width: 50%;">
    <h1> Sandwich Condiments</h1>
    <div>
        <form action="/save" method="post">
        <input type="checkbox" name="condiment" value="Lettuce">Lettuce
        <input type="checkbox" name="condiment" value="Tomato">Tomato
        <input type="checkbox" name="condiment" value="Mustard">Mustard
        <input type="checkbox" name="condiment" value="Sprouts">Sprouts
        <hr>
        <button type="submit">Save</button>
        </form>
        <c:forEach items="${list}" var="condiment">
            <p>${condiment}</p>
        </c:forEach>
        <p>${error}</p>
    </div>
</center>
</body>
</html>