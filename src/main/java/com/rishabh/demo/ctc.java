package com.rishabh.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ctc extends HttpServlet

{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            System.out.println("Inside ctc class");
            HttpSession session = req.getSession();
            String ecode_session = (String) session.getAttribute("ECODE_Session");
            System.out.println("the ecode we got from session is "+ecode_session);

            String ctc = req.getParameter("CTC");
            System.out.println("ctc we are getting is :"+ctc );
            int ctc_got = Integer.parseInt(ctc);
            System.out.println(ctc_got);
            String state = req.getParameter("state");   //............................Changes
            System.out.println("the state we are getting is :"+state);


            Model m = new Model();
            m.setCTC(ctc_got);
            m.setECODE(ecode_session);

            boolean status = m.ctc_set();

            if (status == true) {
                session.setAttribute("ctc_got", ctc_got);
                session.setAttribute("state",state);                //....................Changes
                resp.sendRedirect("ctcsucesspage.jsp");
            } else {
                System.out.println("status false");
                resp.sendRedirect("Error.html");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
