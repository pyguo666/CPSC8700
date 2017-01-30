<%--
  Created by IntelliJ IDEA.
  User: GY
  Date: 11/28/2016
  Time: 03:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Take Eat Easy-User</title>
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
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> Manage Menu <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="adminAddDish.jsp">Add dish</a></li>
                        <li><a href="adminDeleteDish.jsp">Delete dish</a></li>
                        <li><a href="adminUpdateDish.jsp">Update dish</a></li>
                        <li><a href="loadMenu.action">AdminDashboard</a></li>
                    </ul>
                </li>
                <li><a href="logout.action">Log Out</a></li>
            </ul>
        </div>
    </div>
</nav>



<!-- Admin Management Content  -->
<div class="container">
    <h2 class="sub-header">Update Dish</h2>
    <div class="col-md-3 col-md-offset-3 centered">
        <form class="form-horizontal" action="adminUpdate.action">
            <div class="form-group">
                <input type="number" class="form-control" id="dishNum" name="dishID" placeholder="Enter Dish Number">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" id="dishName" name="dishName"  placeholder="Enter Dish Name">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" id="dishURL" name="dishURL"  placeholder="Enter Dish URL">
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-lg btn-block btn-success">Submit</button>
            </div>
        </form>
    </div>
</div>



<footer class="footer navbar-fixed-bottom">
    <div class="container">
        <h6 align="right">This site is made by <a href="mailto:yguo3@clemson.edu">Yang Guo</a> and <a href="mailto:fpei@clemson.edu">Fei Pei</a>.</h6>
    </div>
</footer>
</body>
</html>
