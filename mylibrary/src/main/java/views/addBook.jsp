<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>
            <h1>
                Add A New Book
            </h1>
        </title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    </head>
    <body>
        <div>
            <form name="addBook" method="post" action="insert">
                
                Title: <input type="text" name="title" id="title"/>
                Author: <input type="text" name ="Author" id="Author"/>
                Genre: <input type="text" name ="Genre"id="Genre" />
                Status: <input type="text" name="Status" id="Status "/>
                ISBN: <input type="text" name="isbn" id="isbn"/>

                <input type="submit" value="submit"/>
                
            </form>
        </div>
    </body>
    <script>
        jQuery("#author-form").submit(function (event) {
            var data = JSON.stringify({
                "title": $("#title").val(),
                "Author": $("#Author").val(),
                "Genre": $("#Genre").val(),
                "Status": $("Status").val(),
                "isbn": $("isbn").val()
            });
            console.log(data);
            jQuery.ajax({
                type: "POST",
                url: "/book",
                data: data,
                error: function (params) {
                    alert(params);
                },
                success: function name(params) {
                    window.location.replace("/book");
                },
                dataType: "json",
                contentType: "application/json"
            });
        });
    </script>
</html>