<%@ page language="java" contentType = "text/html; charset =UTF-8" pageEncoding="UTF-8"%>
<html>
    <body>
        <head>
            <title>
                Customer Registration
            </title>
        </head>

        <div>
            <form name="addBook" method="post" action="insert">
                <div>   
                    <stack>
                        <label>
                          Firstname: 
                        </label>
                            <input type="text" name="firstname"/>
                    </stack>
                </div>
                <br>
                <div>
                    <stack>
                        <label>
                            Lastname:
                        </label>
                            <input type="text" name="last_name"/>
                    </stack>
                </div>  
                <br>
                <div>
                    <stack>
                        <label>
                             Email Address:
                        </label>
                            <input type="text" name="email"/>
                    </stack>
                </div> 
                <br>
                <br>
                <p>
                <button onclick="{addNewCustomer}">
                Add a New Customer
                </button>
                </p>
            </form>
        </div>
    </body>
</html>