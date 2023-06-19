<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            width: 70px;
            height: 30px;
            border-radius: 4px;
            background: #217eee;

        }

        .btn a {
            color: white;
            text-decoration: none;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Detail Email</h1>
    <div class="content">
        <table>
            <tbody>
            <tr>
                <th>Languages</th>
                <td>
                    ${email.language}
                </td>
            </tr>
            <tr>
                <th>Page Size:</th>
                <td>
                    Show ${email.pageSize} emails per page
                </td>
            </tr>
            <tr>
                <th>Spams filler:</th>
                <td>
                    <c:if test="${email.spamsFilter==false}">
                        Disable spams filter
                    </c:if>
                    <c:if test="${email.spamsFilter==true}">
                        Enable spams filter
                    </c:if>

                </td>
            </tr>
            <tr>
                <th>Signature:</th>
                <td>
                    ${email.signature}
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <button class="btn"><a href="/email/setting">Setting</a></button>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
