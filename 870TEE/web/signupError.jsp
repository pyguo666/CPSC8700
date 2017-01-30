<%--
  Created by IntelliJ IDEA.
  User: GY
  Date: 11/27/2016
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Take Eat Easy</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="image/yummy1.png" type="image/png">
    <link rel="stylesheet" href="css/signin.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header"><a class="navbar-brand" style="color:#6A374F; font-size:200%" href="#">Take Eat Easy!</a> </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <button type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#signin">Sign In</button>
                </li>
                <li>
                    <button type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#signup">Sign Up</button>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Modal -->
<div class="modal fade" id="signin" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <form class="form-signin" action="login.action">
                <h2 class="form-signin-heading">Please sign in</h2>
                <label for="inputName" class="sr-only">User Name</label>
                <input name="username" type="username" id="inputName" class="form-control" placeholder="User Name" required autofocus >
                <label for="inputPassword" class="sr-only">Password</label>
                <input name="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required />
                <div class="radio">
                    <label>
                        <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
                        Regular User
                    </label>
                </div>
                <div class="radio">
                    <label>
                        <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
                        Administrator
                    </label>
                </div>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign In</button>
            </form>
        </div>
    </div>
</div>
<div class="modal fade" id="signup" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <form class="form-signin" action="signup.action" >
                <h2 class="form-signin-heading">Please sign up</h2>
                <label for="inputName" class="sr-only">User Name</label>
                <input type="name" name="username" id="inputName1" class="form-control" placeholder="User Name" required autofocus>
                <label for="inputPassword" class="sr-only">Password</label>
                <input type="password" name="password" id="inputPassword1" class="form-control" placeholder="Password" required>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign Up</button>
            </form>
        </div>
    </div>
</div>

<div class="container">
    <p>
        <dt>
        <dl><a href="index.jsp">Sorry! This name has been signed up!</a> </dl>
        </dt>
    </p>
</div>

<footer class="footer navbar-fixed-bottom">
    <div class="container">
        <h6 align="right">This site is made by <a href="mailto:yguo3@clemson.edu">Yang Guo</a> and <a href="mailto:fpei@clemson.edu">Fei Pei</a>.</h6>
    </div>
</footer>

</body>
</html>
