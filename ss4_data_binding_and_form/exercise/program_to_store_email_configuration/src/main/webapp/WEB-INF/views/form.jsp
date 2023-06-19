<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: TechCare
  Date: 6/19/2023
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email</title>
    <style>

        .container {
            width: 50%;
        }

        .container h1 {
            margin-left: 20px;
        }

        .content {
            position: relative;
        }

        table {
            border-spacing: 20px;
        }

        th {
            text-align: left;
        }

        .btn {
            height: 30px;
            width: 70px;
            border-radius: 4px;
        }

        #btnSubmit {
            background: #217eee;
            color: white;
            margin-right: 5px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="title">
        <h1>Settings</h1>
    </div>
    <div class="content">
        <table>
            <form:form action="/email/update" method="post" modelAttribute="email">
                <tbody>
                <tr>
                    <th><form:label path="language">Languages</form:label></th>
                    <td>
                        <form:select path="language" items="${language}" style="width: 220px"/>
                    </td>
                </tr>
                <tr>
                    <th>Page Size:</th>
                    <td>
                        Show <form:select path="pageSize" items="${pageSize}"/> emails per page
                    </td>
                </tr>
                <tr>
                    <th>Spams filler:</th>
                    <td>
                        <form:checkbox path="spamsFilter"/> Enable spams filter
                    </td>
                </tr>
                <tr>
                    <th>Signature:</th>
                    <td>
                        <form:textarea path="signature" style="width: 220px"/>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <button class="btn" id="btnSubmit" type="submit">Update</button>
                        <button class="btn" type="reset">Cancel</button>
                    </td>
                </tr>
                </tbody>
            </form:form>
        </table>
    </div>
</div>
</body>
</html>
