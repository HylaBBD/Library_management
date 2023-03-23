<%@ page language="java" contentType = "text/html; charset =UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri ="https://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <hea>
        <title>
            Here is a List of All Customers in your Database
        </title>
    </hea>
    <body>
        <c: foreach customer= "$Customer" var = "customer">
            <tr>

            </p>
        </c: foreach>
    </body>
</html>