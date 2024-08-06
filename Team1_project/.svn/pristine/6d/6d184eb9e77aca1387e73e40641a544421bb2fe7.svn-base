package kr.or.ddit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.IMemberService;
import kr.or.ddit.service.MemberServiceImpl;

@WebServlet("/checkId.do")
public class CheckId extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		
		IMemberService service = MemberServiceImpl.getInstance();
		int cnt = 0;
		String userId = request.getParameter("inputId");
		System.out.println(userId+"!!!!!");
		cnt = service.checkId(userId);
		System.out.println(cnt+"@@@@@");
		if(cnt > 0) {
			 request.getRequestDispatcher("Member/register.jsp").forward(request, response);
		}
		
	}
	

}
