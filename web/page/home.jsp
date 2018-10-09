<%@ page import="com.carbroker.dao.CarDao" %>
<%@ page import="com.carbroker.model.Car" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Davit
  Date: 05.08.2018
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
    <script src="https://unpkg.com/react@16/umd/react.development.js"></script>
    <script src="https://unpkg.com/react-dom@16/umd/react-dom.development.js"></script>
    <script src="https://unpkg.com/babel-standalone@6.15.0/babel.min.js"></script>
</head>
<body>
<jsp:include page="../tamplet/head.jsp"/>

<%--exo--%>
<div id="root"></div>
<script type="text/babel">

    // ReactDOM.render(
    //     <h1>Hello, world!</h1>,
    //     document.getElementById('root')
    // );


    function tick() {
        const element = (
            <div>
                <h2>Time is {new Date().toLocaleTimeString()}.</h2>
            </div>
        );
        // highlight-next-line
        ReactDOM.render(element, document.getElementById('root'));
    }


    setInterval(tick, 1000);

</script>

<div class="aa">

    <%if(request.getAttribute("good")!=""&& request.getAttribute("good")!=null){%>
    <span style="color: greenyellow">
  <%=request.getAttribute("good")%>
  </span>
    <%}
    %>

    <form action="/search" method="post">
        <h3>Name Model: <input type="text" name="searchname"></h3>
        <input type="submit" value="Search">
    </form>

</div>
<h2>Show All Car</h2>

<%
    String searchname=request.getParameter("searchname");
    ArrayList<Car> cars= null ;
    if(searchname==null||searchname==""){
        cars=CarDao.getAllCar();

        }
         else{

        cars=CarDao.getCarByName(searchname);
    }
%>

<div class="panel panel-default" style="margin: 50px">
    <div class="panel-heading">search <%=searchname%> </div>

    <%--<!-- Default panel contents -->--%>
    <%--<div class="panel-heading">All My Car</div>--%>

    <!-- Table -->
    <table class="table">
        ..    <tr>
        <th>Name</th>
        <th>Manifacturer</th>
        <th>Color</th>
        <th>Data</th>
        <th>Price</th>
        <th>Driven</th>
        <th>Info and Buy</th>
    </tr>

        <%

//            ArrayList<Car> cars=CarDao.getAllCar();

            for (Car car : cars) {

        %>
        <tr>
            <td><%=car.getName()%></td>
            <td><%=car.getManifacturer()%></td>
            <td><%=car.getColor()%></td>
            <td><%=car.getData()%></td>
            <td><%=car.getPrice()%></td>
            <td><%=car.getDriven()%></td>
            <td><a href="/page/checkbuyCar/infoCar.jsp?id=<%=car.getId()%>"><span class="glyphicon glyphicon-paste" aria-hidden="true"></span></a></td>

        </tr>
        <%}
        %>

    </table>

</div>
</body>

</html>