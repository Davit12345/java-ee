<%@ page import="com.carbroker.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Davit
  Date: 05.08.2018
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</head>
<body>
<% User user = (User) session.getAttribute("user");%>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">

            <a class="navbar-brand" href="/page/home.jsp">Home</a>
            <a class="navbar-brand" href="/page/myCar.jsp">My Car</a>
            <a class="navbar-brand" href="/page/addMany.jsp">Add  Many</a>

            <span class="navbar-brand"  style="color: yellowgreen" style="margin-left:100px ">Hi <%=user.getFirstname()%></span>


            <a class="navbar-brand" style="margin-left:750px " href="/logout">Logout</a>

            <span class="navbar-brand"  style="color: yellowgreen" style="margin-left:100px ">Deposit <%=user.getAmount()%> $</span>

        </div>
    </div>


</nav>
</body>
</html>
