<%@ page import="com.carbroker.dao.UserDao" %>
<%@ page import="com.carbroker.model.User" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Davit
  Date: 09.08.2018
  Time: 1:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<jsp:include page="../tamplet/head.jsp"/>
<div class="alert alert-danger" >
    <%if(request.getAttribute("msg")!=""&& request.getAttribute("msg")!=null){%>
    <span style="color: red">
  <%=request.getAttribute("msg")%>
  </span>
    <%}
    %>
</div>
<div class="panel panel-default" style="margin: 50px">
    <!-- Default panel contents -->
    <div class="panel-heading">All User</div>

    <!-- Table -->
    <table class="table">
         <tr>
        <th>Email</th>
        <th>FIsrtName</th>
        <th>LastName</th>
        <th>Age</th>
        <th>Amount</th>
        <th>role</th>
             <th>Status</th>
             <th>Block</th>


         </tr>


        <%
            UserDao bookDao=new UserDao();

            ArrayList<User> users=UserDao.getAllUser();

            for (User user : users) {%>
        <tr>
            <td><%=user.getEmail()%></td>
            <td><%=user.getFirstname()%></td>
            <td><%=user.getLastname()%></td>
            <td><%=user.getAge()%></td>
            <td><%=user.getAmount()%></td>
            <td><%=user.getRole()%></td>
            <td><%=user.getStatus()%></td>

            <td><a href="../ServletAdminBlockUser?id=<%=user.getId()%>"><span class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span></a></td></tr>
        </tr>
        <%}
        %>

    </table>

</div>
<p class="copyright">Designed by <a href="/admin/admin.jsp"  title="Colorlib">Go back</a></p>
</body>
</html>
