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
    </head>
    <body>
        <div>
            <form name="addBook" method="post" action="insert">
                
                Title: <input type="text" name="title"/>
                Author: <input type="text" name ="Author"/>
                Genre: <input type="text" name ="Genre"/>
                Status: <input type="text" name="Status"/>
                ISBN: <input type="text" name="isbn"/>

                <input type="submit"/>
                <button onclick="{addNewBook}">Add a Book</button>
                
            </form>
        </div>
    </body>
</html>