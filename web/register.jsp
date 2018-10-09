<%--
  Created by IntelliJ IDEA.
  User: Davit
  Date: 05.08.2018
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Page</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div class="aa">
    <%if(request.getAttribute("errMess")!=""&& request.getAttribute("errMess")!=null){%>
    <span style="color: red">
  <%=request.getAttribute("errMess")%>
  </span>
    <%}
    %>
</div>


<div class="container">
    <form id="contact" action="/registr" method="post">
        <h3>Registration  Page</h3>
        <h4>Plase enter your relly Acount</h4>
        <fieldset>
            <input placeholder="Your Email Address" type="text"name="email"  tabindex="1" required autofocus>
        </fieldset>
        <fieldset>
            <input placeholder="Your  Passwoed" type="password" name="password" tabindex="2" required>
        </fieldset>

        <fieldset>
            <input placeholder="Your  FirstName" type="text" name="firstname" tabindex="2" required>
        </fieldset>

        <fieldset>
            <input placeholder="Your  LastName" type="text" name="lastname" tabindex="2" required>
        </fieldset>

        <fieldset>
            <input placeholder="Your  Age" type="text" name="age" tabindex="2" required>
        </fieldset>

        <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">Submit</button>
        </fieldset>
        <p class="copyright">Designed by <a href="Login.jsp"  title="Colorlib">Go back</a></p>
        <p class="copyright">Designed by <a href="EmailValidation.jsp"  title="Colorlib">Go Validation Page</a></p>

    </form>
</div>
</body>
</html>