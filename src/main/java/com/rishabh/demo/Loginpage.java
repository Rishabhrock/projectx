package com.rishabh.demo;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Loginpage extends HttpServlet
{

    public void service(HttpServletRequest request, HttpServletResponse response) {
        try
        {
            String custid = request.getParameter("ENAME");
            String pw = request.getParameter("ECODE");



            Model m = new Model();
            m.setENAME(custid);
            m.setECODE(pw);
            boolean status = m.login();
            if(status)
            {


                // private String accno;
                int min_wage = m.getMINIMUM_WAGE();
                String location = m.getLOC();
                HttpSession session = request.getSession(true);

                session.setAttribute("ECODE_Session", pw);
                session.setAttribute("min_wage_session", min_wage);
                session.setAttribute("location_session", location);

                response.sendRedirect("details.html");
            }
            else
            {
                System.out.println("status false");
                response.sendRedirect("loginerror.jsp");
            }

//            response.getWriter().append("ENAME: " + custid + " ECODE: " + pw);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}



