package com.rishabh.demo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class Contoller extends HttpServlet
{
////            #########################################################################
    //                                 BASIC
////            #########################################################################
    int basic;

    public int basic_ctc(int ctc,String state)
    {

        System.out.println("###$$$ the state we are getting is :"+state);

        Model m = new Model();
        m.setSTATE(state);
        m.branches();
        int min_wage_session = m.getMINIMUM_WAGES();

         ctc = (ctc * 30 / 100);

        if (ctc > min_wage_session) {
            basic = ((ctc) + ((ctc) - min_wage_session) * 12 / 100 * 76 / 100);
//            It will go to ctc working sheet and search for basic
//            if (ctc*30%)>basic then ((ctc*30%)+((ctc*30)%-basic)*12%*76%))
//            if (ctc*30%)<basic then (ctc*30%)
//            76% = 100%-(12%+12%)

            //     ROUND(IF((I5*30%)>J5,((I5*30%)+((I5*30%)-J5)*12%*76%),MAX(ROUND(I5*30%,0),VLOOKUP(E5,$Branches.$B$2:$C$67,2,0))),0)
        } else {
            if(ctc>min_wage_session) {                                                 //  check once more
                basic = (int)Math.round(ctc);
            }
            else
            {
                basic = (int)Math.round(min_wage_session);
            }


        }


        return basic;
    }

////            #########################################################################
    //                               BONUS
////            #########################################################################
    public int bonus_ctc(int basic)
    {

        int bonus = (int)(Math.round(basic*8.33/100));
        return bonus;
    }



////            #########################################################################
    //                        Employer Contribution
////            #########################################################################



    //   Employer pf


    public int employer_pf_contribution(int basic_got)
    {
        int employer_pf = Math.round(basic_got*12/100);

        return employer_pf;
    }

    //   Gratuity

    public int gratuity_from_ctc(int basic_got)
    {
        int gratuity = (int)Math.round((basic_got*4.81/100));
        return gratuity;
    }

    //    Gross

    public int gross_total(int ctc , int employer_pf , int gratuity)
    {

        int gross = (int) Math.round((ctc-(employer_pf+gratuity))/(1+0.0475));
        return gross;
    }


    //  Employer ESI


    public int employer_esi_contribution(int gross)
    {
        int employer_esi = (int) Math.round((gross * 4.75 / 100));
        return employer_esi;
    }


//           ####################################################################
    //                         Employee Contribution
//          #####################################################################



    // Employee pf

    public int employee_pf_contribution(int basic_got)
    {
        //int basic_got = basic;
        int employee_pf = (int) Math.round((basic_got * 12 / 100));
        return employee_pf;
    }

    //Employee ESI


    public int employee_esi_contribution(int gross)
    {
        int employee_esi = (int) Math.round((gross * 1.75 / 100));
        return employee_esi;
    }

//             ########################################################################
//                                            NetPay
//            #########################################################################

    public int netpay(int gross,int employee_pf,int employee_esi)
    {
        int netpay = gross-employee_pf-employee_esi;

        return netpay;

    }


////             ########################################################################
////                                            Home Rent Allowance
////            #########################################################################


    public  int homerentallowance(int basic_got,int bonus_got,int gross_ded,int netpay_got,String state)
    {
        int hra_inter_if;
        int hra;


        Model m = new Model();
        m.setSTATE(state);
        m.branches();
        int HRA_PERCENT = m.getHRA_PER();


        int hra_calc = netpay_got+gross_ded-basic_got-bonus_got;

        if(hra_calc<0)
        {
            hra_inter_if = 0;
        }
        else{

            hra_inter_if = hra_calc;

        }

        int basic_mul_hra_percentage = basic_got*HRA_PERCENT/100;

        if(hra_inter_if<basic_mul_hra_percentage)
        {

            hra = hra_calc;

        }
        else
        {
            hra = basic_got*HRA_PERCENT/100;

        }
        return hra;
    }



////             ########################################################################
////                                            Gross deduction
////            #########################################################################


    public int grossDed(int employee_pf,int employee_esi)
    {
        int gross_ded = employee_esi+employee_pf;

        return gross_ded;
    }




////             ########################################################################
////                                            Net Take Home
////            #########################################################################


    public int nettakehome(int gross , int gross_ded)
    {
        int nettakehome = gross-gross_ded;

        return nettakehome;
    }



////             ########################################################################
////                                            Difference
////            #########################################################################


    public int difference(int nettakehome,int netpay)
    {

        int diff = nettakehome-netpay;
        return diff;
    }

////             ########################################################################
////                                            Pt Gross
////            #########################################################################

    public int ptgross(int netpay,int gross_ded)
    {
        int ptgross = netpay+gross_ded;
        return ptgross;

    }






    public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {


        String ctc = req.getParameter("CTC");
        int ctc_got = Integer.parseInt(ctc);
        int ctc_session = ctc_got;
        String state = req.getParameter("state");

        HttpSession session = req.getSession();

        String ecode_session = (String) session.getAttribute("ECODE_Session");



        Contoller c = new Contoller();
        int basic_from_method = c.basic_ctc(ctc_got,state);
        int bonus_from_method = c.bonus_ctc(basic_from_method);
        int employer_pf_from_method = c.employer_pf_contribution(basic_from_method);
        int gratuity_from_method = c.gratuity_from_ctc(basic_from_method);
        int gross_total_from_method = c.gross_total(ctc_session,employer_pf_from_method,gratuity_from_method);
        int employer_esi_contribution_from_method = c.employer_esi_contribution(gross_total_from_method);
        int employee_pf_contribution_from_method = c.employee_pf_contribution(basic_from_method);
        int employee_esi_contribution_from_method = c.employee_esi_contribution(gross_total_from_method);
        int netpay_from_method = c.netpay(gross_total_from_method,employee_pf_contribution_from_method,employee_esi_contribution_from_method);
        int grossDed_from_method = c.grossDed(employee_pf_contribution_from_method,employee_esi_contribution_from_method);
        int nettakehome_from_method = c.nettakehome(gross_total_from_method,grossDed_from_method);
        int difference_from_method = c.difference(nettakehome_from_method,netpay_from_method);
        int ptgross_from_method = c.ptgross(netpay_from_method,grossDed_from_method);
        int homerentallowance_from_method = c.homerentallowance(basic_from_method,bonus_from_method,grossDed_from_method,netpay_from_method,state); //changes




        Model m = new Model();
        m.setECODE(ecode_session);
        m.setBASIC(basic_from_method);
        m.setBONUS(bonus_from_method);
        m.setEMPLOYER_PF(employer_pf_from_method);                        //            vvvvvvvvvvvvvv
        m.setGRATUITY(gratuity_from_method);                               //           vvvvvvvvvvvvvv
        m.setGROSS(gross_total_from_method);                                //          vvvvvvvvvvvvv
        m.setEMPLOYER_ESI(employer_esi_contribution_from_method);           //          vvvvvvvvvvvvv
        m.setEMPLOYEE_PF(employee_pf_contribution_from_method);             //          vvvvvvvvvvvvvv
        m.setEMPLOYEE_ESI(employee_esi_contribution_from_method);           //          vvvvvvvvvvvvvvvvvv
        m.setNET_PAY(netpay_from_method);                                   //          vvvvvvvvvvv
        m.setGROSS_DED(grossDed_from_method);                                //         vvvvvvvvvv
        m.setNET_TAKE_HOME(nettakehome_from_method);                         //           vvvvvvvvv
        m.setDIFF(difference_from_method);                                   //          vvvvvvvvvvvvvvv
        m.setPT_GROSS(ptgross_from_method);                                    //        vvvvvvvvvvvvvvvvv
        m.setHRA(homerentallowance_from_method);

        boolean status = m.controller();

        if (status == true) {
            session.setAttribute("ctc_got",ctc_session);
            session.setAttribute("basic_got", basic_from_method);
            session.setAttribute("bonus_got",bonus_from_method);
            session.setAttribute("employer_pf_got",employer_pf_from_method);
            session.setAttribute("gratuity_got",gratuity_from_method);
            session.setAttribute("gross_got",gross_total_from_method);
            session.setAttribute("employer_esi_got",employer_esi_contribution_from_method);
            session.setAttribute("employee_pf_got",employee_pf_contribution_from_method);
            session.setAttribute("employee_esi_got",employee_esi_contribution_from_method);
            session.setAttribute("netpay_got",netpay_from_method);
            session.setAttribute("grossDed_got",grossDed_from_method);
            session.setAttribute("nettakehome_got",nettakehome_from_method);
            session.setAttribute("difference_got",difference_from_method);
            session.setAttribute("ptgross_got",ptgross_from_method);
            session.setAttribute("hra_got",homerentallowance_from_method);

            resp.sendRedirect("full_detail_page.jsp");
        } else {
            System.out.println("status false");
            resp.sendRedirect("Error.html");
        }
    }


}
