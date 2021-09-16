package com.kh.jdbc.member.controller;

import com.kh.jdbc.member.model.service.MemberService;
import com.kh.jdbc.member.model.vo.Member;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MemberLoginServlet
 */
@WebServlet("/login.do")
public class MemberLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public MemberLoginServlet() {
        super();
    }


    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userID = request.getParameter("userId");
        String userPwd = request.getParameter("userPwd");

        Member loginMember = new Member(userID, userPwd);

        MemberService service = new MemberService();

        loginMember = service.selectMember(loginMember);

        if(loginMember != null){
            /*request.setAttribute("member",loginMember);

            RequestDispatcher view = request.getRequestDispatcher("views/member/loginOK.jsp");

            view.forward(request,response);*/

            HttpSession session = request.getSession();

            session.setAttribute("member",loginMember);

            response.sendRedirect("index.jsp");


        }else {
            request.setAttribute("error-msg","로그인 실패!");

            RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");

            view.forward(request,response);
        }
    }
}
