<%@ page import="com.carbroker.dao.CarDao" %>
<%@ page import="com.carbroker.model.Car" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.carbroker.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car list Page</title>
</head>
<body>
<jsp:include page="../tamplet/head.jsp"/>



<div class="aa">

    <%if(request.getAttribute("errMsg")!=""&& request.getAttribute("errMsg")!=null){%>
    <span style="color: greenyellow">
  <%=request.getAttribute("errMsg")%>
  </span>
    <%}
    %>

    <div class="panel panel-default" style="margin: 1px">
        <!-- Default panel contents -->
        <div class="panel-heading">All My Car</div>

        <!-- Table -->
        <table class="table">
            ..    <tr>
            <th>Name</th>
            <th>Manifacturer</th>
            <th>Data</th>
            <th>Price</th>
            <th>Selling</th>
        <th>Update</th>
            <th>Delete</th>
        </tr>

            <% User user = (User) session.getAttribute("user");%>
            <%
                CarDao bookDao=new CarDao();

                ArrayList<Car> cars=CarDao.getCarbyEmail(user.getId());

                for (Car car : cars) {%>
            <tr>
                <td><%=car.getName()%></td>
                <td ><%=car.getManifacturer()%></td>
                <td><%=car.getData()%></td>
                <td><%=car.getPrice()%></td>
                <td><%=car.getSelling()%></td>
                <td><a href="/page/updateCar.jsp?id=<%=car.getId()%>"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a></td>
            <td ><a href="../ServletDeleteCar?id=<%=car.getId()%>"><span class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span></a></td>
            </tr>
            <%}
            %>

        </table>

    </div>
    <p class="copyright">Designed by <a href="/page/addCar.jsp"  title="Colorlib">Add Car</a></p>


</div>
</body>
</html>
