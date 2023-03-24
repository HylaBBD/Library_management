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
        <thead>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Books</th>
        </thead>
        <c:forEach items="${authors}" var="author">
            <tr>
                <td>${author.first_name}</td>
                <td>${author.last_name}</td>
                <td>
                    <ul>
                        <c:forEach items="${author.books}" var="book">
                            <li>${book.title}</li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </c:forEach>
        <tfoot>
            <td><a href="/author-add">Add Another</a></td>
            <td></td>
        </tfoot>
    </table>
</body>
</html>