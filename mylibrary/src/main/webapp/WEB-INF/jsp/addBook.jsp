<html>
    <head>
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
                  <div>   
                    <stack>
                    <label>
                        Book Title: 
                    </label>
                    <input type="text" name="bookTitle"/>
                </stack>
               </div>
                <br>
               <div>
                <stack>
                    <label>
                        Author:
                    </label>
                    <input type="text" name="Author"/>
                </stack>
               </div>  
                <br>
               <div>
                <stack>
                    <label>
                        Firstname:
                    </label>
                    <input type="text" name="Genre"/>
                </stack>
               </div> 
                <br>
               <div>
                 <stack>
                    <label>
                        Status
                    </label>
                    <input type="text" name="Status"/>
                </stack>
               </div>
                <br>
                <p>
                    <button onclick={addNewBook}>
                        Add Book
                    </button>
                </p>
            </form>
        </div>
    </body>
</html>