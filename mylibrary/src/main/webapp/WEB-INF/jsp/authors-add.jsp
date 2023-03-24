<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add New Author</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
</head>
<body>
    <form:form action="/author" method="post" modelAttribute="author" id="author-form">
        <form:label path="first_name">First Name:</form:label><form:input path="first_name" id="first_name"/>
        <br>
        <form:label path="last_name">Last Name:</form:label><form:input type="text" path="last_name" id="last_name"/>
        <br>
        <input type="submit" value="Submit">
    </form:form>
</body>
<script>
    jQuery("#author-form").submit(function (event) {
        var data = JSON.stringify({
            "first_name": $("#first_name").val(),
            "last_name": $("#last_name").val()
        });
        console.log(data);
        jQuery.ajax({
            type: "POST",
            url: "/author",
            data: data,
            error: function (params) {
                alert(params);
            },
            success: function name(params) {
                window.location.replace("/authors");
            },
            dataType: "json",
            contentType: "application/json"
        });
    });
</script>
</html>