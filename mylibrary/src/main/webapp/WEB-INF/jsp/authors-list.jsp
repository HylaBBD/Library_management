<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Authors</title>
</head>
<body>
    List of Authors
    <table>
        <c:forEach items="${authors}" var="author">
            <tr>
                <td>${author.first_name}</td>
                <td>${author.last_name}</td>
            </tr>
        </c:forEach>
        <tr>
            <td><a href="/author-add">Add Another</a></td>
            <td></td>
        </tr>
    </table>
</body>
</html>