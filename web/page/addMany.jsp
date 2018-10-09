<%--
  Created by IntelliJ IDEA.
  User: Davit
  Date: 06.08.2018
  Time: 1:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Many </title>
    <link rel="stylesheet" type="text/css" href="../style.css">

</head>
<body>
<jsp:include page="../tamplet/head.jsp"/>



<div class="aa">

    <%if(request.getAttribute("errMess")!=""&& request.getAttribute("errMess")!=null){%>
    <span style="color: greenyellow">
  <%=request.getAttribute("errMess")%>
  </span>
    <%}
    %>
</div>

<form id="contact" action="/addMany" method="post">
    <h3>Add Many  Page</h3>

    <fieldset>
        <input placeholder="Add  Many" type="number"name="many"  tabindex="1" required autofocus>
    </fieldset>

    <fieldset style="font-size: 25px">
    <button  name="submit" type="submit" id="contact-submit" data-submit="...Sending">Submit</button>
    </fieldset>

</form>
</body>
</html>
