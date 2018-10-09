<%--
  Created by IntelliJ IDEA.
  User: Davit
  Date: 06.08.2018
  Time: 2:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:include page="../tamplet/head.jsp"/>

<div class="alert alert-danger" role="alert">
    <%if(request.getAttribute("msg")!=""&& request.getAttribute("msg")!=null){%>
    <span style="color: blue">
  <%=request.getAttribute("msg")%>
  </span>
    <%}
    %>
</div>
<div style="margin-left: 600px " />
<h1 style="color: green" > Admin Page</h1>
<p><a class="btn btn-primary btn-lg" href="/admin/ListforUser.jsp" role="button">User List</a></p>
<br><br>
<p><a class="btn btn-primary btn-lg" href="/admin/ListforCar.jsp" role="button">Car List</a></p>

</body>
</body>
</html>
