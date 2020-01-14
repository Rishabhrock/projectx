package com.rishabh.demo;


import java.sql.*;

public class Model {


    String ECODE;
    String ENAME;
    String LOC;
    String STATE;
    int HRA;
    int NET_TAKE_HOME;
    int CTC;
    int BASIC;
    int BONUS;
    int SPLL;
    int EMPLOYER_PF;
    int EMPLOYER_ESI;
    int GRATUITY;
    int GROSS;
    int EMPLOYEE_PF;
    int EMPLOYEE_ESI;
    int EMPLOYEE_PT;
    int EMPLOYEE_LWF;
    int GROSS_DED;
    int DIFF;
    int PT_GROSS;
    int MINIMUM_WAGE;
    int NET_PAY;
    int HRA_PERCENT;
    String STATE_CODE;
    int MINIMUM_WAGES;
    int HRA_PER;


    private ResultSet res = null;
    public PreparedStatement pstmt = null;
    public Connection con = null;


    public String getECODE() {
        return ECODE;
    }

    public void setECODE(String ECODE) {
        this.ECODE = ECODE;
    }

    public String getENAME() {
        return ENAME;
    }

    public void setENAME(String ENAME) {
        this.ENAME = ENAME;
    }

    public String getLOC() {
        return LOC;
    }

    public void setLOC(String LOC) {
        this.LOC = LOC;
    }

    public String getSTATE() {
        return STATE;
    }

    public void setSTATE(String STATE) {
        this.STATE = STATE;
    }

    public int getHRA() {
        return HRA;
    }

    public void setHRA(int HRA) {
        this.HRA = HRA;
    }

    public int getNET_TAKE_HOME() {
        return NET_TAKE_HOME;
    }

    public void setNET_TAKE_HOME(int NET_TAKE_HOME) {
        this.NET_TAKE_HOME = NET_TAKE_HOME;
    }

    public int getCTC() {
        return CTC;
    }

    public void setCTC(int CTC) {
        this.CTC = CTC;
    }

    public int getBASIC() {
        return BASIC;
    }

    public void setBASIC(int BASIC) {
        this.BASIC = BASIC;
    }

    public int getBONUS() {
        return BONUS;
    }

    public void setBONUS(int BONUS) {
        this.BONUS = BONUS;
    }

    public int getSPLL() {
        return SPLL;
    }

    public void setSPLL(int SPLL) {
        this.SPLL = SPLL;
    }

    public int getEMPLOYER_PF() {
        return EMPLOYER_PF;
    }

    public void setEMPLOYER_PF(int EMPLOYER_PF) {
        this.EMPLOYER_PF = EMPLOYER_PF;
    }

    public int getEMPLOYER_ESI() {
        return EMPLOYER_ESI;
    }

    public void setEMPLOYER_ESI(int EMPLOYER_ESI) {
        this.EMPLOYER_ESI = EMPLOYER_ESI;
    }

    public int getGRATUITY() {
        return GRATUITY;
    }

    public void setGRATUITY(int GRATUITY) {
        this.GRATUITY = GRATUITY;
    }

    public int getGROSS() {
        return GROSS;
    }

    public void setGROSS(int GROSS) {
        this.GROSS = GROSS;
    }

    public int getEMPLOYEE_PF() {
        return EMPLOYEE_PF;
    }

    public void setEMPLOYEE_PF(int EMPLOYEE_PF) {
        this.EMPLOYEE_PF = EMPLOYEE_PF;
    }

    public int getEMPLOYEE_ESI() {
        return EMPLOYEE_ESI;
    }

    public void setEMPLOYEE_ESI(int EMPLOYEE_ESI) {
        this.EMPLOYEE_ESI = EMPLOYEE_ESI;
    }

    public int getEMPLOYEE_PT() {
        return EMPLOYEE_PT;
    }

    public void setEMPLOYEE_PT(int EMPLOYEE_PT) {
        this.EMPLOYEE_PT = EMPLOYEE_PT;
    }

    public int getEMPLOYEE_LWF() {
        return EMPLOYEE_LWF;
    }

    public void setEMPLOYEE_LWF(int EMPLOYEE_LWF) {
        this.EMPLOYEE_LWF = EMPLOYEE_LWF;
    }

    public int getGROSS_DED() {
        return GROSS_DED;
    }

    public void setGROSS_DED(int GROSS_DED) {
        this.GROSS_DED = GROSS_DED;
    }

    public int getDIFF() {
        return DIFF;
    }

    public void setDIFF(int DIFF) {
        this.DIFF = DIFF;
    }

    public int getPT_GROSS() {
        return PT_GROSS;
    }

    public void setPT_GROSS(int PT_GROSS) {
        this.PT_GROSS = PT_GROSS;
    }


    public int getMINIMUM_WAGE() {
        return MINIMUM_WAGE;
    }

    public void setMINIMUM_WAGE(int MINIMUM_WAGE) {
        this.MINIMUM_WAGE = MINIMUM_WAGE;
    }

    public int getNET_PAY() {
        return NET_PAY;
    }

    public void setNET_PAY(int NET_PAY) {
        this.NET_PAY = NET_PAY;
    }


    public int getHRA_PERCENT() {
        return HRA_PERCENT;
    }

    public void setHRA_PERCENT(int HRA_PERCENT) {
        this.HRA_PERCENT = HRA_PERCENT;
    }

    public String getSTATE_CODE() {
        return STATE_CODE;
    }

    public void setSTATE_CODE(String STATE_CODE) {
        this.STATE_CODE = STATE_CODE;
    }

    public int getMINIMUM_WAGES() {
        return MINIMUM_WAGES;
    }

    public void setMINIMUM_WAGES(int MINIMUM_WAGES) {
        this.MINIMUM_WAGES = MINIMUM_WAGES;
    }

    public int getHRA_PER() {
        return HRA_PER;
    }

    public void setHRA_PER(int HRA_PER) {
        this.HRA_PER = HRA_PER;
    }



    Model() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("inside Model");
            con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE", "rishabh", "SYSTEM");
            System.out.println("inside connection");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean login() {
        try {
            pstmt = con.prepareStatement("SELECT * FROM EMPLOYEE WHERE ENAME = ? AND ECODE = ?");

            pstmt.setString(1, ENAME);
            System.out.println("Ename is"+ENAME);
            pstmt.setString(2, ECODE);
            System.out.println("Ecode is"+ECODE);
            res = pstmt.executeQuery();

            if (res.next() == true) {

                MINIMUM_WAGE = res.getInt("MINIMUM_WAGE");
                LOC = res.getString("LOC");
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean ctc_set() {
        try {
            pstmt = con.prepareStatement("UPDATE EMPLOYEE SET CTC=? WHERE ECODE=?");
            System.out.println("inside ctc_set method");
            pstmt.setInt(1, CTC);
            System.out.println("The ctc we are fixing is :"+CTC);
            pstmt.setString(2, ECODE);
            System.out.println(ECODE);
            int row = pstmt.executeUpdate();
            System.out.println("INSIDE CTC_SET row value"+row);

            if (row == 1) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }



    public boolean register() {
        try {

            pstmt = con.prepareStatement("INSERT INTO EMPLOYEE (ECODE, ENAME, LOC ) VALUES (?,?,?)");

            pstmt.setString(1, ECODE);

            pstmt.setString(2, ENAME);
            pstmt.setString(3, LOC);
            int row = pstmt.executeUpdate();


            if (row == 1) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean controller() {

        try {

            pstmt = con.prepareStatement("UPDATE EMPLOYEE SET BASIC=?,BONUS=?,EMPLOYER_PF=?,GRATUITY=?,GROSS=?,EMPLOYER_ESI=?,EMPLOYEE_PF=?,EMPLOYEE_ESI=?,GROSS_DED=?,NET_TAKE_HOME=?,DIFF=?,PT_GROSS=? WHERE ECODE=?");




                         pstmt.setInt(1, BASIC);
                         pstmt.setInt(2, BONUS);
                         pstmt.setInt(3, EMPLOYER_PF);
                         pstmt.setInt(4, GRATUITY);
                         pstmt.setInt(5, GROSS);
                         pstmt.setInt(6, EMPLOYER_ESI);
                         pstmt.setInt(7, EMPLOYEE_PF);
                         pstmt.setInt(8, EMPLOYEE_ESI);
                         pstmt.setInt(9,GROSS_DED);
                         pstmt.setInt(10,NET_TAKE_HOME);
                         pstmt.setInt(11,DIFF);
                         pstmt.setInt(12,PT_GROSS);

                         pstmt.setString(13, ECODE);






            int row = pstmt.executeUpdate();


            if (row == 1) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }



    public void branches() {
        try {

            pstmt = con.prepareStatement("SELECT * FROM BRANCHES WHERE STATE=?");

            pstmt.setString(1, STATE);

            res = pstmt.executeQuery();

            if (res.next() == true) {

                HRA_PER = res.getInt("HRA_PER");
                MINIMUM_WAGES = res.getInt("MINIMUM_WAGES");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}