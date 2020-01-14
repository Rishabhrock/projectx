package com.rishabh.demo;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Register extends HttpServlet
{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {


       String Ename = req.getParameter("ENAME");
        String Ecode = req.getParameter("ECODE");
        String location = req.getParameter("Location");

        Model m = new Model();
        m.setENAME(Ename);
        m.setECODE(Ecode);
        m.setLOC(location);

        boolean status = m.register();

        if(status)
        {
            resp.sendRedirect("index.jsp");
        }
        else
        {
            System.out.println("status false");
            resp.sendRedirect("loginerror.jsp");
        }

    }
}
