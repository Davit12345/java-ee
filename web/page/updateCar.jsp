<%@ page import="com.carbroker.model.Car" %>
<%@ page import="com.carbroker.dao.CarDao" %><%--
  Created by IntelliJ IDEA.
  User: Davit
  Date: 06.08.2018
  Time: 23:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Car</title>
    <link rel="stylesheet" type="text/css" href="../style.css">

</head>
<body>
<jsp:include page="../tamplet/head.jsp"/>
<%
    String sid=request.getParameter("id");
    int id=Integer.parseInt(sid);
    CarDao carDao=new CarDao();
    Car car=carDao.getCarById(id);
%>
<%car.getName();%>
<div class="container">
    <form id="contact" action="/UpdateandSave" method="post">

        <h3>Update   Car</h3>

            <input value="<%=car.getId()%>" type="hidden"name="id"  >

        <fieldset>
            <input value="<%=car.getName()%>" type="text" name="name" tabindex="2" required>
        </fieldset>

        <fieldset>
            <input value="<%=car.getManifacturer()%>" type="text" name="manifacrurer" tabindex="2" required>
        </fieldset>

        <fieldset>
            <input value="<%=car.getColor()%>" type="text" name="color" tabindex="2" required>
        </fieldset>

        <fieldset>
            <input value="<%=car.getSelling()%>" type="text" name="sell" tabindex="2" required>
        </fieldset>
        <fieldset>
            <input value="<%=car.getPrice()%>" type="number" name="price" tabindex="2" required>$
        </fieldset>
        <fieldset>
            <input value="<%=car.getData()%>" type="number" name="data" tabindex="2" required>
        </fieldset>

        <fieldset>
            <input value="<%=car.getDriven()%>" type="number" name="driven" tabindex="2" required>km
        </fieldset>




        <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">Submit</button>
        </fieldset>


    </form>
</div>
</body>
</html>
