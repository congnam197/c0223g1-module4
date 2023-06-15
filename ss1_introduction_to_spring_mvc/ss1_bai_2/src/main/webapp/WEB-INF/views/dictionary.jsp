<%--
  Created by IntelliJ IDEA.
  User: TechCare
  Date: 6/15/2023
  Time: 2:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .container {
            justify-content: center;
            align-items: center;
            width: 50%;
            border-radius: 5px;
            border: 1px solid #5151ee;
        }

        .title {
            justify-items: center;
            color: rgba(255, 0, 0, 0.58);
        }

        .container p {
            font-weight: bold;
        }

        .content form input, button {
            height: 40px;
        }
    </style>
</head>
<body>
<center>
    <div class="container">
        <div class="title">
            <h2>Dictionary</h2>
        </div>
        <div class="content">
            <form method="get" action="/search/dictionary">
                <input id="search" type="text" name="word" value="${word}" placeholder="Enter a word">
                <button type="submit">Search</button>
            </form>
            <p>Result : ${result}</p>
        </div>
    </div>
</center>
</body>
</html>
