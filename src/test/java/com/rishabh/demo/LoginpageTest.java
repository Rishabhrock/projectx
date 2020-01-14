package com.rishabh.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.http.HttpServletRequest;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;



class LoginpageTest {

    @Mock
    HttpServletRequest request;


    @BeforeEach
    void setUp() {

        MockitoAnnotations.initMocks(this);

    }

    public boolean login(String username,String password){
        Model m = new Model();
        m.setENAME(username);
        m.setECODE(password);
        return m.login();
    }
    @Test
    void service() {


        when(request.getParameter("ENAME")).thenReturn("AMBEDKAR");
        when(request.getParameter("ECODE")).thenReturn("SLV7166");


        boolean check1 = login("AMBEDKAR","SLV7166");

        assertTrue(check1);


    }
}


