<%@ page import="com.carbroker.dao.CarDao" %>
<%@ page import="com.carbroker.model.Car" %><%--
  Created by IntelliJ IDEA.
  User: Davit
  Date: 07.08.2018
  Time: 1:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Info</title>
    <link rel="stylesheet" type="text/css" href="../style.css">

</head>
<body>
<jsp:include page="../../tamplet/head.jsp"/>

<div class="aa">
    <%if(request.getAttribute("errMsg")!=""&& request.getAttribute("errMsg")!=null){%>
    <span style="color: red">
  <%=request.getAttribute("errMsg")%>
  </span>
    <%}
    %>
</div>

<%
    String sid=request.getParameter("id");
    int id=Integer.parseInt(sid);
    CarDao carDao=new CarDao();
    Car car=carDao.getCarById(id);
%>
<%car.getName();%>
<div class="container">
    <form id="contact" action="/BuyCar" method="post">
        <input value="<%=car.getId()%>" type="hidden"name="id"  >
        <h3>Info   Car</h3>

        <input value="<%=car.getId()%>" type="hidden"name="id"  >


        <h3>Model- "<%=car.getName()%>" </h3>

        <p> Manifacturer-<%=car.getManifacturer()%> </p>

        <p> Color- <%=car.getColor()%> </p>
        <p> Price-<%=car.getPrice()%>  $</p>
        <p> Data- <%=car.getData()%> </p>
        <p> Driven- <%=car.getDriven()%> km </p>




        <button name="Submit" type="submit" id="contact-submit" data-submit="...Sending">Buy</button>
        <p class="copyright">Designed by <a href="/page/home.jsp"  title="Colorlib">Go back</a></p>

        </fieldset>


    </form>
</div>
</body>
</html>
