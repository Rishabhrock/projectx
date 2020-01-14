package com.rishabh.demo;

import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ContollerTest extends TestCase{

int ctc;
String state;


    @BeforeEach
   protected void setUp() {

        ctc = 15509;
        state = "Hyderabad";


    }

    @Test
   void basic_ctc() {

      Contoller c =new Contoller();
      int basic_got = c.basic_ctc(ctc,state);
      assertEquals(null,basic_got);

    }

    @Test
    void bonus_ctc() {



        Contoller c = new Contoller();
        int bonus = c.bonus_ctc(c.basic_ctc(ctc,state));

        assertEquals(764,bonus);

    }

    @Test
    void employer_pf_contribution() {

        Contoller c = new Contoller();

        int epf = c.employer_pf_contribution(c.basic_ctc(ctc,state));

        assertEquals(1100,epf);
    }

    @Test
    void gratuity_from_ctc() {

        Contoller c =new Contoller();
       int gratuity = c.gratuity_from_ctc(c.basic_ctc(ctc,state));
       assertEquals(441,gratuity);
    }

    @Test
    void gross_total() {

        Contoller c = new Contoller();
       int gross = c.gross_total(ctc,c.employer_pf_contribution(c.basic_ctc(ctc,state)),c.gratuity_from_ctc(c.basic_ctc(ctc,state)));
       assertEquals(13335,gross);

    }

    @Test
    void employer_esi_contribution() {

        Contoller c = new Contoller();
        int employer_esi = c.employer_esi_contribution(c.gross_total(ctc,c.employer_pf_contribution(c.basic_ctc(ctc,state)),c.gratuity_from_ctc(c.basic_ctc(ctc,state))));
        assertEquals(633,employer_esi);
    }

    @Test
    void employee_pf_contribution() {
        Contoller c = new Contoller();
       int employee_pf_contribution =  c.employee_pf_contribution(c.basic_ctc(ctc,state));
        assertEquals(1100,employee_pf_contribution);
    }

    @Test
    void employee_esi_contribution() {

        Contoller c = new Contoller();
        int employee_esi_contribution = c.employee_esi_contribution(c.gross_total(ctc,c.employer_pf_contribution(c.basic_ctc(ctc,state)),c.gratuity_from_ctc(c.basic_ctc(ctc,state))));
        assertEquals(233,employee_esi_contribution);
    }

    @Test
    void netpay() {

        Contoller c = new Contoller();
        int netpay = c.netpay(c.gross_total(ctc,c.employer_pf_contribution(c.basic_ctc(ctc,state)),c.gratuity_from_ctc(c.basic_ctc(ctc,state))),c.employee_pf_contribution(c.basic_ctc(ctc,state)),c.employee_esi_contribution(c.gross_total(ctc,c.employer_pf_contribution(c.basic_ctc(ctc,state)),c.gratuity_from_ctc(c.basic_ctc(ctc,state)))));
        assertEquals(12002,netpay);
    }

    @Test
    void homerentallowance() {
        Contoller c = new Contoller();
        int hra = c.homerentallowance(c.basic_ctc(ctc,state),c.bonus_ctc(c.basic_ctc(ctc,state)),c.grossDed( c.employee_pf_contribution(c.basic_ctc(ctc,state)),c.employee_esi_contribution(c.gross_total(ctc,c.employer_pf_contribution(c.basic_ctc(ctc,state)),c.gratuity_from_ctc(c.basic_ctc(ctc,state))))),c.netpay(c.gross_total(ctc,c.employer_pf_contribution(c.basic_ctc(ctc,state)),c.gratuity_from_ctc(c.basic_ctc(ctc,state))),c.employee_pf_contribution(c.basic_ctc(ctc,state)),c.employee_esi_contribution(c.gross_total(ctc,c.employer_pf_contribution(c.basic_ctc(ctc,state)),c.gratuity_from_ctc(c.basic_ctc(ctc,state))))),state);
        assertEquals(3400,hra);
    }

    @Test
    void grossDed() {
        Contoller c = new Contoller();
       int grossDed = c.grossDed( c.employee_pf_contribution(c.basic_ctc(ctc,state)),c.employee_esi_contribution(c.gross_total(ctc,c.employer_pf_contribution(c.basic_ctc(ctc,state)),c.gratuity_from_ctc(c.basic_ctc(ctc,state)))));
        assertEquals(1333,grossDed);
    }

    @Test
    void nettakehome() {

        Contoller c =new Contoller();
        int nettakehome = c.nettakehome(c.gross_total(ctc,c.employer_pf_contribution(c.basic_ctc(ctc,state)),c.gratuity_from_ctc(c.basic_ctc(ctc,state))),c.grossDed( c.employee_pf_contribution(c.basic_ctc(ctc,state)),c.employee_esi_contribution(c.gross_total(ctc,c.employer_pf_contribution(c.basic_ctc(ctc,state)),c.gratuity_from_ctc(c.basic_ctc(ctc,state))))));
        assertEquals(12002,nettakehome);
    }

    @Test
    void difference() {

        Contoller c = new Contoller();
        int difference = c.difference(c.nettakehome(c.gross_total(ctc,c.employer_pf_contribution(c.basic_ctc(ctc,state)),c.gratuity_from_ctc(c.basic_ctc(ctc,state))),c.grossDed( c.employee_pf_contribution(c.basic_ctc(ctc,state)),c.employee_esi_contribution(c.gross_total(ctc,c.employer_pf_contribution(c.basic_ctc(ctc,state)),c.gratuity_from_ctc(c.basic_ctc(ctc,state)))))),c.netpay(c.gross_total(ctc,c.employer_pf_contribution(c.basic_ctc(ctc,state)),c.gratuity_from_ctc(c.basic_ctc(ctc,state))),c.employee_pf_contribution(c.basic_ctc(ctc,state)),c.employee_esi_contribution(c.gross_total(ctc,c.employer_pf_contribution(c.basic_ctc(ctc,state)),c.gratuity_from_ctc(c.basic_ctc(ctc,state))))));
        assertEquals(0,difference);
    }

    @Test
    void ptgross() {
        Contoller c = new Contoller();
        int ptgross = c.ptgross(c.netpay(c.gross_total(ctc,c.employer_pf_contribution(c.basic_ctc(ctc,state)),c.gratuity_from_ctc(c.basic_ctc(ctc,state))),c.employee_pf_contribution(c.basic_ctc(ctc,state)),c.employee_esi_contribution(c.gross_total(ctc,c.employer_pf_contribution(c.basic_ctc(ctc,state)),c.gratuity_from_ctc(c.basic_ctc(ctc,state))))),c.grossDed( c.employee_pf_contribution(c.basic_ctc(ctc,state)),c.employee_esi_contribution(c.gross_total(ctc,c.employer_pf_contribution(c.basic_ctc(ctc,state)),c.gratuity_from_ctc(c.basic_ctc(ctc,state))))));
        assertEquals(13335,ptgross);
    }


}