<%--
  Created by IntelliJ IDEA.
  User: Davit
  Date: 06.08.2018
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Car</title>
    <link rel="stylesheet" type="text/css" href="../style.css">

</head>
<body>
<jsp:include page="../tamplet/head.jsp"/>

<div class="aa">
    <%if(request.getAttribute("errMess")!=""&& request.getAttribute("errMess")!=null){%>
    <span style="color: red">
  <%=request.getAttribute("errMess")%>
  </span>
    <%}
    %>
</div>


<div class="container">
    <form id="contact" action="/addCar" method="post">
        <h3>Add   Car</h3>
        <fieldset>
            <input placeholder="Car Name" type="text"name="name"  tabindex="1" required autofocus>
        </fieldset>
        <fieldset>
            <input placeholder="  Manifacturer" type="text" name="manifacrurer" tabindex="2" required>
        </fieldset>

        <fieldset>
            <input placeholder="Color" type="text" name="color" tabindex="2" required>
        </fieldset>
        <fieldset>
            <input placeholder="Selling yes/no" type="text" name="sell" tabindex="2" required>
        </fieldset>
        <fieldset>
            <input placeholder="price" type="number" name="price" tabindex="2" required> $
        </fieldset>

        <fieldset>
            <input placeholder="Car  Data" type="number" name="data" tabindex="2" required>
        </fieldset>


        <fieldset>
            <input placeholder="Driven" type="number" name="driven" tabindex="2" required> km
        </fieldset>


        <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">Submit</button>
        </fieldset>


    </form>
</div>
</body>
</html>
