<%--
  Created by IntelliJ IDEA.
  User: Davit
  Date: 05.08.2018
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="style.css">

</head>
<body>
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
    <form id="contact" action="/EmailValidation" method="post">
        <h3>Validation Gmail  Page</h3>
        <h4>Plase enter your Valid Cod </h4>
        <h3>See in Gmail</h3>
        <fieldset>
            <input placeholder="Your  Email" type="text"name="email"  tabindex="1" required autofocus>
        </fieldset>
        <fieldset>
            <input placeholder="Write Code" type="text" name="validationcod"  tabindex="1" maxlength="6" minlength="6" required autofocus>
        </fieldset>


        <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">Submit</button>
        </fieldset>
        <p class="copyright">Designed by <a href="/register.jsp"  title="Colorlib">Go register</a></p>
    </form>
</div>
</body>
</html>
