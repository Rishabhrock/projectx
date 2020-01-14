<%--
  Created by IntelliJ IDEA.
  User: rishabh
  Date: 03/01/20
  Time: 2:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ctc sucess page</title>
</head>
<body>

<center>



<form action="Contoller" method="post">

<h2>

    CTC was updated sucessfully....

</h2>

<% out.println("CTC Provided for "+session.getAttribute("ECODE_Session") + " is :");%>
<br/>
<% out.println(session.getAttribute("ctc_got"));%>


    <br/><input type="submit" value="Click to continue">
</form>

</center>
</body>
</html>
