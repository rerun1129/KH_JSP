package com.kh.jdbc.member.controller;

import com.kh.jdbc.member.model.service.MemberService;
import com.kh.jdbc.member.model.vo.Member;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/memberDelete.do")
public class MemberDeleteServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Member m = (Member) session.getAttribute("member");
        String userId = m.getUserId();

        MemberService service = new MemberService();

        int result = service.deleteMember(userId);

        if(result>0){
            session.invalidate();
            response.sendRedirect("index.jsp");
        }else {
            request.setAttribute("error-msg","회원 탈퇴 실패");

            RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");

            view.forward(request,response);
        }
    }
}
