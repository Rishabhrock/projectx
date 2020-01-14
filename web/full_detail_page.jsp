<%--
  Created by IntelliJ IDEA.
  User: rishabh
  Date: 06/01/20
  Time: 10:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$full_detail_page$</title>
</head>
<body>
<center>
<h2>
    <br> -------------------------------------------------------------------------<br>
    CTC split up<br>
    -------------------------------------------------------------------------<br>

</h2>
<% out.println("CTC splitup for "+session.getAttribute("ECODE_Session") + " is as follow :");%>
<br/>
<br/>
<% out.println("CTC :"+session.getAttribute("ctc_got"));%>
<br/>
<% out.println("Basic :" +session.getAttribute("basic_got"));%>
<br/>
<% out.println("Bonus :"+session.getAttribute("bonus_got"));%>
<br/>
<% out.println("HRA :"+session.getAttribute("hra_got"));%>
<br/>
<% out.println("Gross "+session.getAttribute("gross_got"));%>
<br/>
<% out.println("Net Take Home :"+session.getAttribute("nettakehome_got"));%><br>
<br/>
<h1>
    -------------------------------------------------------------------------<br>
    Employer Contribution<br>
    -------------------------------------------------------------------------<br>
</h1>
<br/>
<% out.println("  Employer Pf  : " +session.getAttribute("employer_pf_got"));%>
<br/>
<% out.println("  Employer Esi  : " +session.getAttribute("employer_esi_got"));%>
<br/>
<% out.println("  Gratuity  : " +session.getAttribute("gratuity_got"));%>

<br/>
<h1>
    -------------------------------------------------------------------------<br>
    Employee Contribution<br>
    -------------------------------------------------------------------------<br>
</h1>
<br/>
<% out.println("  Employee Pf  : " +session.getAttribute("employee_pf_got"));%>
<br/>
<% out.println("  Employee Esi  : " +session.getAttribute("employee_esi_got"));%>
<br/>
<h1>
    -------------------------------------------------------------------------<br>
Gross<br>
    -------------------------------------------------------------------------<br>
</h1>
<br>
<% out.println("  Gross  : " +session.getAttribute("gross_got"));%>
<h1>
    -------------------------------------------------------------------------<br>
    Gross Deduction<br>
    -------------------------------------------------------------------------<br>
</h1>
<br/>
<% out.println("Gross Deduction :"+session.getAttribute("grossDed_got"));%>
<h1>
    -------------------------------------------------------------------------<br>
    Net Pay<br>
    -------------------------------------------------------------------------<br>
</h1>
<br/>
<% out.println("Net Pay :"+session.getAttribute("netpay_got"));%><br>

<h1>
    -------------------------------------------------------------------------<br>
    Differnce<br>
    -------------------------------------------------------------------------<br>
</h1>
<br/>
<% out.println("Difference :"+session.getAttribute("difference_got"));%><br>


<h1>
    -------------------------------------------------------------------------<br>
    Pt Gross<br>
    -------------------------------------------------------------------------<br>
</h1>
<br/>
<% out.println("Pt Gross :"+session.getAttribute("ptgross_got"));%><br>
    <h2>
        -------------------------------------------------------------------------<br>
    </h2>
</center>
</body>
</html>
