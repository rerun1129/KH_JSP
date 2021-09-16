package com.kh.jdbc.member.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "memberLogoutServlet", urlPatterns = "/logout.do")
public class MemberLogoutServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if(session != null){

            System.out.println(session.getId());

            session.invalidate();

        }

        response.sendRedirect("index.jsp");
    }
}
