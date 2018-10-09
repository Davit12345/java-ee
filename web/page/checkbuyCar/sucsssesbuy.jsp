<%--
  Created by IntelliJ IDEA.
  User: Davit
  Date: 07.08.2018
  Time: 2:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sucsses</title>
</head>
<body>
<jsp:include page="../../tamplet/head.jsp"/>
<div class="aa">
    <%if(request.getAttribute("errMess")!=""&& request.getAttribute("errMess")!=null){%>
    <span style="color: red">
  <%=request.getAttribute("errMess")%>
  </span>
    <%}
    %>
</div>
<h2>You have new Car</h2>

</body>
</html>
