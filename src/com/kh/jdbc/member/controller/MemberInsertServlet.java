package com.kh.jdbc.member.controller;

import com.kh.jdbc.member.model.service.MemberService;
import com.kh.jdbc.member.model.vo.Member;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/memberInsert.do")
public class MemberInsertServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.  문자셋 변경
        request.setCharacterEncoding("UTF-8");

        // 2. join.jsp에서 작성한 정보 받아오기
        String userId = request.getParameter("userId");
        String userPwd = request.getParameter("userPwd");
        String userName = request.getParameter("userName");
        String gender = request.getParameter("gender");
        int age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        // 취미는 같은 이름 속성의 값들이
        // 배열 형식으로 전달된다.
        String[] hobby = request.getParameterValues("hobby");
        String hobbyStringify = String.join(", ", hobby);

        // 3. 객체(VO)를 하나 생성하여 값을 한 번에 담아 처리하기
        Member m = new Member(userId, userPwd, userName, gender, age,
                email, phone, address, hobbyStringify, null);

        System.out.println("가입자 정보 : " + m);

        // 4. 업무(서비스) 처리 객체 생성
        MemberService service = new MemberService();

        int result = service.insertMember(m);

        if( result > 0 ) {
            // redirect 방식
            System.out.println("회원 가입 성공!");

            response.sendRedirect("index.jsp");
        } else {
            // forward 방식
            System.out.println("회원 가입 실패!");

            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            RequestDispatcher view
                    = request.getRequestDispatcher("views/common/errorPage.jsp");

            request.setAttribute("error-msg", "회원 가입 실패!");


            view.forward(request, response);
        }

    }




}
