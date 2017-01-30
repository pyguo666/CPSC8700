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
                <li><a href="loadUserDash.action">DashBoard</a> </li>
                <li><a href="userDeleteRecord.jsp">Add NotLike</a> </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> My Account <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="loadUser.action">Manage</a></li>
                        <li><a href="logout.action">Log Out</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>



<!--  Management Content  -->
<div class="container">
    <h2 class="sub-header">Food I May Like</h2>
    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>#</th>
                <th>Name</th>
                <th>URL</th>
            </tr>
            </thead>
            <tbody>
            <s:iterator status="stat" value="prefList">
                <tr>
                    <td><s:property value="dishID"/></td>
                    <td><s:property value="dishName"/></td>
                    <td><s:property value="dishURL"/></td>
                </tr>
            </s:iterator>
            <tr>
                <td> </td>
                <td> </td>
                <td> </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>



<footer class="footer navbar-fixed-bottom">
    <div class="container">
        <h6 align="right">This site is made by <a href="mailto:yguo3@clemson.edu">Yang Guo</a> and <a href="mailto:fpei@clemson.edu">Fei Pei</a>.</h6>
    </div>
</footer>
</body>
</html>
