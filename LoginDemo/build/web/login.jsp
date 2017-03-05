<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="newcss.css">
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <center><img class="cupcakeImage" src="CupcakeImage.jpg"></img></center>
        <div class="loginMenu">
        <form action="LoginServlet" method="post">
            <label>Username</label>
            <input type="text" name="username" value=""></input>
            <label>Password</label>
            <input type="password" name="password" value=""</input>
            <input type="submit" value="Login"</input>
        </form>
            <center><a href="index.jsp">back to homescreen</a></center>
        </div>
    </body>
</html>
