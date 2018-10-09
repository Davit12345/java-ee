<%--
  Created by IntelliJ IDEA.
  User: Davit
  Date: 05.08.2018
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <%if(request.getAttribute("errMess")!=""&& request.getAttribute("errMess")!=null){%>
<span style="color: red">
  <%=request.getAttribute("errMess")%>
  </span>
    <%}
%>
</div>
<div class="aa">

    <%if(request.getAttribute("good")!=""&& request.getAttribute("good")!=null){%>
    <span style="color: greenyellow">
  <%=request.getAttribute("good")%>
  </span>
    <%}
    %>
</div>
<div class="container">
    <form id="contact" action="/login" method="post">
        <h3>Login Page</h3>
        <h4>Plase enter your relly site</h4>
        <fieldset>
            <input placeholder="Your Email Address" type="text"name="email"  tabindex="1" required autofocus>
        </fieldset>
        <fieldset>
            <input placeholder="Your  Passwoed" type="password" name="password" tabindex="2" required>
        </fieldset>
        <fieldset>
            <input placeholder="Remmeber me  " type="checkbox" name="remmember"  >
        </fieldset>

        <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">Submit</button>
        </fieldset>
        <p class="copyright">Designed by <a href="register.jsp"  title="Colorlib">Go register</a></p>
    </form>
</div>
</body>
</html>
